package com.example.hospitalvisitors.service;

import com.example.hospitalvisitors.domain.dto.VisitRequest;
import com.example.hospitalvisitors.domain.dto.VisitResponse;
import com.example.hospitalvisitors.domain.entity.User;
import com.example.hospitalvisitors.domain.entity.Visit;
import com.example.hospitalvisitors.repository.UserRepository;
import com.example.hospitalvisitors.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final UserRepository userRepository;

    public VisitResponse writeNewRecord(String uid, VisitRequest visitRequest) { // specific user id is conveyed
        Visit visit = visitRequest.toEntity(); // user id is then saved as well as any other info in visitRequest
        User user = userRepository.findByUid(uid).orElseThrow(RuntimeException::new);
        visit.setUserId(user);
        Visit savedVisit = visitRepository.save(visit);
        return Visit.of(savedVisit);
    }
}
