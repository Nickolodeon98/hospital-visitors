package com.example.hospitalvisitors.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public enum ErrorCode {

    DUPLICATE_ID(HttpStatus.CONFLICT, "이미 존재하는 아이디입니다.");

    private final HttpStatus httpStatus;
    private final String message;

}
