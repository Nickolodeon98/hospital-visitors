package com.example.hospitalvisitors.domain.dto;

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
}
