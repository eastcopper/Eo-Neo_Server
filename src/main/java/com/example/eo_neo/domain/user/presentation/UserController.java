package com.example.eo_neo.domain.user.presentation;

import com.example.eo_neo.domain.user.presentation.dto.request.PostPlanRequest;
import com.example.eo_neo.domain.user.presentation.dto.response.UserInfoResponse;
import com.example.eo_neo.domain.user.service.GetPlanService;
import com.example.eo_neo.domain.user.service.PostPlanService;
import com.example.eo_neo.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService service;
    private final PostPlanService postPlanService;
    private final GetPlanService getPlanService;

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

    @PostMapping("/plan")
    public void postPlan(@RequestBody PostPlanRequest request) {
        postPlanService.excute(request);
    }

    @GetMapping("/plan")
    public List<List<String>> getPlan() {
        return getPlanService.excute();
    }
}
