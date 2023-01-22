package com.spring.mvc.admission_committee.service;

import com.spring.mvc.admission_committee.dao.SpecialtyDao;
import com.spring.mvc.admission_committee.entity.Applicant;
import com.spring.mvc.admission_committee.entity.Specialty;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SpecialtyServiceImplementation implements SpecialtyService {
    private final SpecialtyDao specialtyDao;

    public SpecialtyServiceImplementation(SpecialtyDao specialtyDao) {
        this.specialtyDao = specialtyDao;
    }

    @Override
    @Transactional
    public List<Specialty> getAllSpecialties() {
        return specialtyDao.getAllSpecialties();
    }

    @Override
    @Transactional
    public void saveSpecialty(Specialty specialty) {
        specialtyDao.saveSpecialty(specialty);
    }

    @Override
    @Transactional
    public Specialty getSpecialty(Integer specialtyId) {
        return specialtyDao.getSpecialty(specialtyId);
    }

    @Override
    @Transactional
    public void deleteSpecialty(Integer specialtyId) {
        specialtyDao.deleteSpecialty(specialtyId);
    }

    @Override
    @Transactional
    public void addSpecialtiesToApplicant(List<Specialty> specialties, Applicant applicant) {
        specialtyDao.addSpecialtiesToApplicant(specialties, applicant);
    }
}
