package com.example.hospitalvisitors.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
public class VisitRequest {

    private Long hospitalId;
    private Long diseaseId;
    private Date recordedAt;
    private Long diagnosisFee;
}
