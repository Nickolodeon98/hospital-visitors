package com.example.hospitalvisitors.domain.dto;

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

}
