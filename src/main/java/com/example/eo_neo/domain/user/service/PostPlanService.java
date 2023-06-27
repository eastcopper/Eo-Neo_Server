package com.example.eo_neo.domain.user.service;

import com.example.eo_neo.domain.question.domain.Question;
import com.example.eo_neo.domain.user.domain.Plan;
import com.example.eo_neo.domain.user.domain.User;
import com.example.eo_neo.domain.user.domain.repository.UserRepository;
import com.example.eo_neo.domain.user.presentation.dto.request.PostPlanRequest;
import com.example.eo_neo.global.security.auth.Details;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostPlanService {
    private final UserRepository userRepository;

    public void excute(PostPlanRequest request) {
        UsernamePasswordAuthenticationToken contextInfo = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Details details = (Details) contextInfo.getPrincipal();
        User user = details.getUser();
        userRepository.save(user.planAdd(request.getPlan()));
    }
}
