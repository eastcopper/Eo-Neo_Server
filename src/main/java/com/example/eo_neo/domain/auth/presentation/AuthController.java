package com.example.eo_neo.domain.auth.presentation;

import com.example.eo_neo.domain.auth.presentation.dto.request.SignUpRequest;
import com.example.eo_neo.domain.auth.presentation.dto.response.TokenResponse;
import com.example.eo_neo.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public void signUp(@RequestBody SignUpRequest request) {
        authService.signUo(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody SignUpRequest request) {
        return authService.login(request);
    }
}
