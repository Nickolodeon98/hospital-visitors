package com.example.hospitalvisitors.controller;

import com.example.hospitalvisitors.domain.dto.VisitRequest;
import com.example.hospitalvisitors.domain.dto.VisitResponse;
import com.example.hospitalvisitors.service.VisitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VisitController.class)
class VisitControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    VisitService visitService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("사용자 정보와 병원 정보가 들어 있는 방문 내역을 저장한다.")
    public void save_visit_history() throws Exception {
        String uid = "sjeon0730";// 사용자 아이디

        VisitRequest visitRequest = new VisitRequest(1L, 1L); // 가짜 요청

        VisitResponse visitResponse = VisitResponse.builder() // 가짜 응답
                .diseaseName("감기")
                .hospitalName("참조은의원")
                .userName("sjeon0730")
                .build();

        given(visitService.writeNewRecord(uid, visitRequest)).willReturn(visitResponse);

        String url = "/api/visits/new";
        mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(visitRequest))
                .content(objectMapper.writeValueAsString("uid")).with(csrf()))
                .andExpect(status().isOk())
                .andDo(print());

        verify(visitService).writeNewRecord(uid, visitRequest);
    }


}