package com.spring.mvc.admission_committee.dao;

import com.spring.mvc.admission_committee.entity.Specialty;

import java.util.List;

public interface SpecialtyDao {

    List<Specialty> getAllSpecialties();

    void saveSpecialty(Specialty specialty);

    Specialty getSpecialty(Integer specialtyId);

    void deleteSpecialty(Integer specialtyId);
}
