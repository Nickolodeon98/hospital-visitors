package com.example.hospitalvisitors.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hospitalName;
    private String roadNameAddress;
    private String businessTypeName;

    @OneToMany
    private List<Visit> visits;
}
