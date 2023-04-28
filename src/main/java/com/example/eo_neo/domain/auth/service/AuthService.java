package com.example.eo_neo.domain.auth.service;

import com.example.eo_neo.domain.auth.presentation.dto.request.SignUpRequest;
import com.example.eo_neo.domain.auth.presentation.dto.response.TokenResponse;
import com.example.eo_neo.domain.user.domain.User;
import com.example.eo_neo.domain.user.domain.repository.UserRepository;
import com.example.eo_neo.global.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtProvider jwtProvider;

    public void signUo(SignUpRequest request) {
        // 암호화한 후 db에 저장
        String dbPass = passwordEncoder.encode(request.getPassword());
        // account 아이디 확인 >> 귀찮아서 패스
        userRepository.save(
                User.builder()
                        .accountId(request.getAccountId())
                        .nickName(request.getNickName())
                        .password(dbPass)
                        .build()
        );
    }

    public TokenResponse login(SignUpRequest request) {
        // userRepository에서 id를 찾아 user 객체 반환 >> 없으면 예외 처리 날리기
        User user = userRepository.findByAccountId(request.getAccountId()).orElseThrow(RuntimeException::new);

        // 요청받은 password와 user의 암호화된 password를 matches로 비교 >> 틀리면 예외 처리
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) throw new RuntimeException();

        // accessToken과 refreshToken 반환
        return TokenResponse.builder()
                .accessToken(jwtProvider.accessTokenGenerator(user.getAccountId()))
                .refreshToken(jwtProvider.refreshTokenGenerator(user.getAccountId()))
                .build();
    }
}
