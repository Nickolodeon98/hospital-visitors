package com.example.hospitalvisitors.service;

import com.example.hospitalvisitors.domain.entity.Hospital;
import com.example.hospitalvisitors.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public Page<Hospital> findAllHospitals(Pageable pageable) {
        return hospitalRepository.findAll(pageable);
    }

}
