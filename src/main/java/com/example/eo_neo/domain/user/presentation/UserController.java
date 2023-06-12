package com.example.eo_neo.domain.user.presentation;

import com.example.eo_neo.domain.user.presentation.dto.response.UserInfoResponse;
import com.example.eo_neo.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService service;

    @GetMapping
    public UserInfoResponse get() {
        return service.getUser();
    }

    @PutMapping("/clear/log")
    public void clearLog() {
        service.clearLog();
    }

    @DeleteMapping("/delete")
    public void deleteUser() {
        service.deleteUser();
    }
}
