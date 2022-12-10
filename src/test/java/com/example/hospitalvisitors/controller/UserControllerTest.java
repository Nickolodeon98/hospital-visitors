package com.example.hospitalvisitors.controller;

import com.example.hospitalvisitors.domain.dto.JoinRequest;
import com.example.hospitalvisitors.domain.dto.JoinResponse;
import com.example.hospitalvisitors.exception.ErrorCode;
import com.example.hospitalvisitors.exception.JoinException;
import com.example.hospitalvisitors.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmNativeQueryJoinReturnType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@RequiredArgsConstructor
class UserControllerTest {

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    private final ObjectMapper objectMapper;

    private JoinRequest joinRequest;
    private JoinResponse joinResponse;

    @BeforeEach
    void setUp() {
        joinRequest = JoinRequest.builder()
                .name("전승환")
                .userId("sjeon0730")
                .password("12345678")
                .build();

        joinResponse = JoinResponse.builder()
                .userId("sjeon0730")
                .name("전승환")
                .message("회원가입에 성공했습니다.")
                .build();
    }


    @Test
    @DisplayName("회원가입에 성공한다.")
    void join_success() throws Exception {
        given(userService.joinUser(joinRequest)).willReturn(joinResponse);

        String url = "/api/users/join";

        mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(joinRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("회원가입에 성공했습니다."))
                .andDo(print());

        verify(userService).joinUser(joinRequest);
    }

    @Test
    @DisplayName("회원가입에 실패한다.")
    void join_fail() throws Exception {
        given(userService.joinUser(any())).willThrow(new JoinException(ErrorCode.DUPLICATE_ID));

        String url = "/api/users/join";
        mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(any())))
                .andExpect(status().isConflict())
                .andDo(print());

        verify(userService).joinUser(any());
    }
}