package com.example.hospitalvisitors.domain.dto;

import com.example.hospitalvisitors.domain.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class LoginRequest {

    private String userId;

    public User toEntity() {
        return User.builder()
                .uid(userId)
                .build();
    }
}
