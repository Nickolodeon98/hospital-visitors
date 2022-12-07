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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uid;


    @OneToMany
    private List<Visit> visits;
}
