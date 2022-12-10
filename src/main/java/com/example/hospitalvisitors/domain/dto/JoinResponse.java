package com.example.hospitalvisitors.domain.dto;

import com.example.hospitalvisitors.domain.entity.User;
import lombok.*;

@Builder
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class JoinResponse {

    private String userId;
    private String name;
    private String message;

    public static JoinResponse fromEntity(User user) {
        return JoinResponse.builder()
                .message("회원가입에 성공했습니다.")
                .userId(user.getUid())
                .name(user.getName())
                .build();
    }
}
