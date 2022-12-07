package com.example.hospitalvisitors.repository;

import com.example.hospitalvisitors.domain.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
