package com.example.hospitalvisitors.controller;

import com.example.hospitalvisitors.domain.dto.VisitRequest;
import com.example.hospitalvisitors.domain.dto.VisitResponse;
import com.example.hospitalvisitors.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/visits")
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

    /* 첫 번째 API:
     * TODO: visit 테이블에 사용자에 대한 정보와 방문한 병원 정보를 저장한다 */
    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<VisitResponse> recordHistory(@RequestBody VisitRequest visitRequest, Authentication authentication) {
        VisitResponse visitResponse = visitService.writeNewRecord(authentication.getName(), visitRequest);
        return ResponseEntity.ok().body(visitResponse);
    }

}
