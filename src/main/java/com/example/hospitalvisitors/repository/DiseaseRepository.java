package com.example.hospitalvisitors.repository;

import com.example.hospitalvisitors.domain.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    Optional<Disease> findByDiseaseName(String diseaseName);
}
