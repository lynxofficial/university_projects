package com.spring.mvc.admission_committee.service;

import com.spring.mvc.admission_committee.entity.Applicant;

import java.util.List;

public interface ApplicantService {

    List<Applicant> getAllApplicants();

    void saveApplicant(Applicant applicant);

    Applicant getApplicant(Integer applicantId);

    void deleteApplicant(Integer applicantId);
}
