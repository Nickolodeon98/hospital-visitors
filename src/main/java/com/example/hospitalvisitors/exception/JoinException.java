package com.example.hospitalvisitors.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JoinException extends RuntimeException {

    private ErrorCode errorCode;
}
