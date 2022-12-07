package com.example.hospitalvisitors.domain.entity;

import com.fasterxml.jackson.databind.DatabindException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
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



}
