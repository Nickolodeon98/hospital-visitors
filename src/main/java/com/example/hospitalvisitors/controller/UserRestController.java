package com.example.hospitalvisitors.controller;

import com.example.hospitalvisitors.domain.dto.LoginRequest;
import com.example.hospitalvisitors.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserRestController {

    private final UserService userService;


    /* 두 번째 API:
     * TODO: 명시하는 아이디로 로그인한다. */
    @PostMapping("/login")
    public ResponseEntity<String> loginWithUserId(@RequestBody LoginRequest loginRequest) {
        log.info("loginRequest:{}", loginRequest);
        String token = userService.authenticate(loginRequest);
        return ResponseEntity.ok().body(token);
    }
}
