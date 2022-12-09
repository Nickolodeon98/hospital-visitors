package com.example.hospitalvisitors.controller;

import com.example.hospitalvisitors.domain.entity.Hospital;
import com.example.hospitalvisitors.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/hospitals")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    /* 모든 병원들의 정보를 조회할 수 있는 API */
    @GetMapping("/list")
    public String showAllHospitals(Model model, @PageableDefault(size = 20, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Hospital> hospitals = hospitalService.findAllHospitals(pageable);
        model.addAttribute("hospitals", hospitals);
        model.addAttribute("previous", pageable.previousOrFirst());
        model.addAttribute("next", pageable.next());

        return "hospitals/show";
    }
}
