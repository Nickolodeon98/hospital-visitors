package com.example.hospitalvisitors.service;

import com.example.hospitalvisitors.domain.dto.LoginRequest;
import com.example.hospitalvisitors.domain.entity.User;
import com.example.hospitalvisitors.repository.UserRepository;
import com.example.hospitalvisitors.utils.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Value("${jwt.secret}")
    private String secretKey;

    public String authenticate(LoginRequest loginRequest) {
        userRepository.save(loginRequest.toEntity());
        return JwtTokenProvider.createToken(secretKey, loginRequest.getUserId());
    }

    public String testSave(LoginRequest loginRequest) {
        userRepository.save(loginRequest.toEntity());
        return "";
    }

}
