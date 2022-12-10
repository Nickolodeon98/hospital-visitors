package com.example.hospitalvisitors.exception;

import com.example.hospitalvisitors.domain.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionManager {

//    @ExceptionHandler(JoinException.class)
//    @ResponseBody
//    public ResponseEntity<?> joinExceptionHandler(JoinException e) {
//        return ResponseEntity.status(e.getErrorCode().getHttpStatus())
//                .body(Response.error(e.getErrorCode().getMessage()));
//    }

    @ExceptionHandler(JoinException.class)
    public String joinExceptionHandler(JoinException e, Model model) {
        model.addAttribute("errorCode", e.getErrorCode().name());
        model.addAttribute("message", e.getErrorCode().getMessage());
        return "hospitals/error";
    }

}
