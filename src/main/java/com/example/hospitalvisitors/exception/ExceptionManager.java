package com.example.hospitalvisitors.exception;

import com.example.hospitalvisitors.domain.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {



    @ExceptionHandler(JoinException.class)
    public ResponseEntity<?> joinExceptionHandler(JoinException e) {
        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
                .body(Response.error(e.getErrorCode().getMessage()));
    }


}
