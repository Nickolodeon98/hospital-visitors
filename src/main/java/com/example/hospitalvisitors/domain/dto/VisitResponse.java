package com.example.hospitalvisitors.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class VisitResponse {

    private String userName;
    private String hospitalName;
    private String diseaseName;
}
