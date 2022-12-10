package com.example.hospitalvisitors.service;

import com.example.hospitalvisitors.domain.dto.JoinRequest;
import com.example.hospitalvisitors.domain.dto.JoinResponse;
import com.example.hospitalvisitors.domain.dto.LoginRequest;
import com.example.hospitalvisitors.domain.entity.User;
import com.example.hospitalvisitors.repository.UserRepository;
import com.example.hospitalvisitors.utils.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String secretKey;

    public JoinResponse joinUser(JoinRequest joinRequest) {
        String encodedPassword = passwordEncoder.encode(joinRequest.getPassword()); // 패스워드를 해싱합니다.
        User savedUser = userRepository.save(joinRequest.toEntity(encodedPassword));
        return JoinResponse.fromEntity(savedUser);
    }

    public String authenticate(LoginRequest loginRequest) {
        userRepository.save(loginRequest.toEntity());
        return JwtTokenProvider.createToken(secretKey, loginRequest.getUserId());
    }



}
