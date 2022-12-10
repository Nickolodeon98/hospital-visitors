package com.example.hospitalvisitors.domain;

import lombok.*;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Response<T> {

    private T result;
    private String message;

    public static <T> Response<T> success(T dto) {
        return new Response<>(dto, "SUCCESS");
    }

    public static <T> Response<T> error(String message) {
        return new Response<>(null, message);
    }
}
