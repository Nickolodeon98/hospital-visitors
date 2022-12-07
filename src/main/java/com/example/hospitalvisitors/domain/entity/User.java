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

    @Column(unique = true)
    private String uid;


    @OneToMany(mappedBy = "user")
    private List<Visit> visits;
}
