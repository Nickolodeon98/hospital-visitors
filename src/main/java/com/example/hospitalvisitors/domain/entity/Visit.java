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
@ToString(callSuper = true)
public class Visit extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 방문 내역 각각의 고유 아이디

    private Long diagnosisFee;
    private Date recordedAt;

    @ManyToOne
    private Disease disease;

    @ManyToOne
    private Hospital hospital;

    @ManyToOne
    private User user;

    public static VisitResponse of(Visit visit) {
        return VisitResponse.builder()
                .userName(visit.getUser().getUid())
                .hospitalName(visit.getHospital().getHospitalName())
                .diseaseName(visit.getDisease().getDiseaseName())
                .recordedAt(visit.recordedAt)
                .diagnosisFee(visit.diagnosisFee)
                .build();
    }

    public void setUser(User user) {
        this.user = user;
    }

}
