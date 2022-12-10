package com.example.hospitalvisitors.controller;

import com.example.hospitalvisitors.domain.dto.JoinRequest;
import com.example.hospitalvisitors.domain.dto.LoginRequest;
import com.example.hospitalvisitors.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/join")
    public String homeScreen() {
        return "/hospitals/join";
    }

    @PostMapping("/join")
    public String join(JoinRequest joinRequest) {
        log.info("userID:{}", joinRequest.getUserId());
        userService.joinUser(joinRequest);
        return "redirect:/api/users/home";
    }

    /* 두 번째 API:
     * TODO: 명시하는 아이디로 로그인한다. */
    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity<String> loginWithUserId(@RequestBody LoginRequest loginRequest) {
        log.info("loginRequest:{}", loginRequest);
        String token = userService.authenticate(loginRequest);
        return ResponseEntity.ok().body(token);
    }
}
