package com.example.eo_neo.domain.user.service;

import com.example.eo_neo.domain.user.domain.User;
import com.example.eo_neo.domain.user.domain.repository.UserRepository;
import com.example.eo_neo.domain.user.presentation.dto.response.UserInfoResponse;
import com.example.eo_neo.global.security.auth.Details;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserInfoResponse getUser() {
        UsernamePasswordAuthenticationToken contextInfo = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Details details = (Details) contextInfo.getPrincipal();
        User user = details.getUser();
        return UserInfoResponse.builder()
                .accountId(user.getAccountId())
                .nickName(user.getNickName())
                .CorrectConversation(user.getCorrectConversation())
                .CorrectWord(user.getCorrectWord())
                .CorrectBasic(user.getCorrectBasic())
                .CorrectLanguage(user.getCorrectLanguage())
                .build();
    }

    public void clearLog() {
        UsernamePasswordAuthenticationToken contextInfo = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Details details = (Details) contextInfo.getPrincipal();
        User user = details.getUser();
        user.setCorrectLanguage(0);
        user.setCorrectWord(0);
        user.setCorrectBasic(0);
        user.setCorrectConversation(0);
        userRepository.save(user);
    }

    public void deleteUser() {
        UsernamePasswordAuthenticationToken contextInfo = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Details details = (Details) contextInfo.getPrincipal();
        User user = details.getUser();
        userRepository.delete(user);
    }


//    public UserInfoResponse get(Long id) {
//        User user = userRepository.findById(id)
//                .orElseThrow(RuntimeException::new);
//        return UserInfoResponse.builder()
//                .accountId(user.getAccountId())
//                .nickName(user.getNickName())
//                .CorrectLanguage(user.getCorrectLanguage())
//                .CorrectBasic(user.getCorrectBasic())
//                .CorrectWord(user.getCorrectWord())
//                .CorrectConversation(user.getCorrectConversation())
//               .build();
//    }
//
//    public UserInfoResponse update(Long id, String nickName) {
//        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
//        user.setNickName(nickName);
//        userRepository.save(user);
//        return UserInfoResponse.builder()
//                .nickName(user.getNickName())
//                .accountId(user.getAccountId())
//                .build();
//    }
//
//    public void delete(Long id) {
//        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
//        userRepository.delete(user);
//    }
}
