package com.example.hospitalvisitors.controller;

import com.example.hospitalvisitors.domain.dto.LoginRequest;
import com.example.hospitalvisitors.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    /* 두 번째 API:
     * TODO: 명시하는 아이디로 로그인한다. */
    @PostMapping("/login")
    public ResponseEntity<String> loginWithUserId(@RequestBody LoginRequest loginRequest) {
        String token = userService.authenticate(loginRequest.getUserId());

        return ResponseEntity.ok().body(token);
    }
}
