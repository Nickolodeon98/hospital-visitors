package com.example.hospitalvisitors.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class VisitRequest {

    private Long hospitalId;
    private Long diseaseId;
}
