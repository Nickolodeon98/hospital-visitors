package com.example.hospitalvisitors.service;

import com.example.hospitalvisitors.domain.dto.VisitRequest;
import com.example.hospitalvisitors.domain.dto.VisitResponse;
import com.example.hospitalvisitors.domain.entity.Disease;
import com.example.hospitalvisitors.domain.entity.Hospital;
import com.example.hospitalvisitors.domain.entity.User;
import com.example.hospitalvisitors.domain.entity.Visit;
import com.example.hospitalvisitors.repository.DiseaseRepository;
import com.example.hospitalvisitors.repository.HospitalRepository;
import com.example.hospitalvisitors.repository.UserRepository;
import com.example.hospitalvisitors.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final UserRepository userRepository;

    private final DiseaseRepository diseaseRepository;

    private final HospitalRepository hospitalRepository;

    public VisitResponse writeNewRecord(String uid, VisitRequest visitRequest) { // specific user id is conveyed
        Visit visit = visitRequest.toEntity(); // user id is then saved as well as any other info in visitRequest
        User user = userRepository.findByUid(uid).orElseThrow(RuntimeException::new);
        visit.setUser(user); // 찾은 User 객체를 visit 테이블에 추가한다.

        /* 위에서 사용자 아이디로 찾았듯이, 각각 병명과 병원 명으로 Disease 와 Hospital 객체를 찾아서 저장한다. */
        Disease disease = diseaseRepository.findByDiseaseName(visitRequest.getDiseaseName()).orElseThrow(RuntimeException::new);
        visit.setDisease(disease); // 찾은 Disease 를 visit 테이블에 추가한다.

        Hospital hospital = hospitalRepository.findByHospitalName(visitRequest.getHospitalName()).orElseThrow(RuntimeException::new);
        visit.setHospital(hospital); // 찾은 Hospital 를 visit 테이블에 추가한다.

        Visit savedVisit = visitRepository.save(visit);
        return Visit.of(savedVisit);
    }
}
