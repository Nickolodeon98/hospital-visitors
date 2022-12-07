package com.example.hospitalvisitors.domain.entity;

import com.example.hospitalvisitors.domain.dto.VisitResponse;
import com.fasterxml.jackson.databind.DatabindException;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 방문 내역 각각의 고유 아이디

    private Long diagnosisFee;
    private Date recordedAt;

    @OneToOne
    private Disease disease;

    @ManyToOne
    private Hospital hospitalId;

    @ManyToOne
    private User userId;

    public static VisitResponse of(Visit visit) {
        return VisitResponse.builder()
                .userName(visit.getUserId().getUid())
                .hospitalName(visit.getHospitalId().getHospitalName())
                .diseaseName(visit.getDisease().getDiseaseName())
                .recordedAt(visit.recordedAt)
                .diagnosisFee(visit.diagnosisFee)
                .build();
    }

    public void setUser(User user) {
        this.userId = user;
    }

}
