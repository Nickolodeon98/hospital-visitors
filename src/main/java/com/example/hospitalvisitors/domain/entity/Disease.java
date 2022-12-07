package com.example.hospitalvisitors.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String diseaseName;

    @OneToOne
    private Visit visit;
}
