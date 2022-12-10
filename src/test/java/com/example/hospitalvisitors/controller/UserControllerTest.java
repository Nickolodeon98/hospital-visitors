package com.example.hospitalvisitors.controller;

import com.example.hospitalvisitors.domain.dto.JoinRequest;
import com.example.hospitalvisitors.domain.dto.JoinResponse;
import com.example.hospitalvisitors.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmNativeQueryJoinReturnType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
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

    @Test
    @DisplayName("회원가입에 성공한다.")
    void join_success() throws Exception {

        JoinRequest joinRequest = JoinRequest.builder()
                .name("전승환")
                .userId("sjeon0730")
                .password("12345678")
                .build();

        JoinResponse joinResponse = JoinResponse.builder()
                        .userId("sjeon0730")
                        .name("전승환")
                        .message("회원가입에 성공했습니다.")
                        .build();

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
}