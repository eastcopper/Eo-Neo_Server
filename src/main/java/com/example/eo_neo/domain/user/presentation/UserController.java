package com.example.eo_neo.domain.user.presentation;

import com.example.eo_neo.domain.user.presentation.dto.response.UserInfoResponse;
import com.example.eo_neo.domain.user.presentation.dto.request.UserNickRequest;
import com.example.eo_neo.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    public UserInfoResponse get(@PathVariable Long id) {
        return service.get(id);
    }

//    @PutMapping("/{id}")
//    public UserInfoResponse update(@PathVariable Long id, @RequestParam String nickName) {
//        return service.update(id, nickName);
//    }

    @PutMapping("/{id}")
    public UserInfoResponse update(@PathVariable Long id, @RequestBody UserNickRequest request){
        return service.update(id, request.getNickName());
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
