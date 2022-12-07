package com.example.hospitalvisitors.service;

import com.example.hospitalvisitors.repository.UserRepository;
import com.example.hospitalvisitors.utils.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Value("${jwt.secret}")
    private String secretKey;

    public String authenticate(String uid) {
        return JwtTokenProvider.createToken(secretKey, uid);
    }

}
