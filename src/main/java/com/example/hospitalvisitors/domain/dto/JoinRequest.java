package com.example.hospitalvisitors.domain.dto;

import com.example.hospitalvisitors.domain.entity.User;
import lombok.*;

@Builder
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class JoinRequest {

    private String name;
    private String userId;
    private String password;

    public User toEntity(String encodedPassword) {
        return User.builder()
                .uid(userId)
                .password(encodedPassword)
                .build();
    }
}
