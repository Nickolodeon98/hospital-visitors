package com.example.hospitalvisitors.service;

import com.example.hospitalvisitors.domain.dto.VisitRequest;
import com.example.hospitalvisitors.domain.dto.VisitResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;

    public VisitResponse writeNewRecord(String uid, VisitRequest visitRequest) {

    }
}
