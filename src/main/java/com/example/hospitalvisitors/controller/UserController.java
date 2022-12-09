package com.example.hospitalvisitors.controller;

import com.example.hospitalvisitors.domain.dto.LoginRequest;
import com.example.hospitalvisitors.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/home")
    public String homeScreen() {
        return "hospitals/home";
    }

    @PostMapping("/test")
    public String testLogin(LoginRequest loginRequest) {
        log.info("userID:{}", loginRequest.getUserId());
        userService.testSave(loginRequest);
        return "redirect:/api/users/home";
    }
}
