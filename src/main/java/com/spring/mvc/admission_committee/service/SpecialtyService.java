package com.spring.mvc.admission_committee.service;

import com.spring.mvc.admission_committee.entity.Specialty;

import java.util.List;

public interface SpecialtyService {

    List<Specialty> getAllSpecialties();

    void saveSpecialty(Specialty specialty);

    Specialty getSpecialty(Integer specialtyId);

    void deleteSpecialty(Integer specialtyId);
}
