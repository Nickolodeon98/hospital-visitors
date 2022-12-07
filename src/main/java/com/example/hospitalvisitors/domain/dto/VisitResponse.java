package com.example.hospitalvisitors.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Builder
public class VisitResponse {

    private String userName;
    private String hospitalName;
    private String diseaseName;
    private Date recordedAt;
    private Long diagnosisFee;
}
