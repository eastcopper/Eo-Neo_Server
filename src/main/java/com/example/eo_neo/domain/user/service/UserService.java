package com.example.eo_neo.domain.user.service;

import com.example.eo_neo.domain.user.domain.User;
import com.example.eo_neo.domain.user.domain.repository.UserRepository;
import com.example.eo_neo.domain.user.presentation.dto.response.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserInfoResponse get(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return UserInfoResponse.builder()
                .accountId(user.getAccountId())
                .nickName(user.getNickName())
                .build();
    }

    public UserInfoResponse update(Long id, String nickName) {
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        user.setNickName(nickName);
        userRepository.save(user);
        return UserInfoResponse.builder()
                .nickName(user.getNickName())
                .accountId(user.getAccountId())
                .build();
    }

    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        userRepository.delete(user);
    }
}
