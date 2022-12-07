package com.example.hospitalvisitors.domain.dto;

import com.example.hospitalvisitors.domain.entity.Visit;
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

    private String hospitalName;
    private String diseaseName;
    private Date recordedAt;
    private Long diagnosisFee;

    public Visit toEntity() {
        return Visit.builder()
                .diagnosisFee(diagnosisFee)
                .recordedAt(recordedAt)
                .build();
    }
}
