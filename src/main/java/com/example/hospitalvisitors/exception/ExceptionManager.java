package com.example.hospitalvisitors.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {



    @ExceptionHandler(JoinException.class)
    public static ResponseEntity<?> joinError() {

        return
    }


}
