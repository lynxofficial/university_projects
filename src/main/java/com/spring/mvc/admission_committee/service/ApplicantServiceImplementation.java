package com.spring.mvc.admission_committee.service;

import com.spring.mvc.admission_committee.dao.ApplicantDao;
import com.spring.mvc.admission_committee.entity.Applicant;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ApplicantServiceImplementation implements ApplicantService {
    private final ApplicantDao applicantDao;

    public ApplicantServiceImplementation(ApplicantDao applicantDao) {
        this.applicantDao = applicantDao;
    }

    @Override
    @Transactional
    public List<Applicant> getAllApplicants() {
        return applicantDao.getAllApplicants();
    }

    @Override
    @Transactional
    public void saveApplicant(Applicant applicant) {
        applicantDao.saveApplicant(applicant);
    }

    @Override
    @Transactional
    public Applicant getApplicant(Integer applicantId) {
        return applicantDao.getApplicant(applicantId);
    }

    @Override
    @Transactional
    public void deleteApplicant(Integer applicantId) {
        applicantDao.deleteApplicant(applicantId);
    }

    @Override
    @Transactional
    public List<Applicant> createListOfApplicants() {
        return applicantDao.createListOfApplicants();
    }
}
