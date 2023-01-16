package com.spring.mvc.admission_committee.dao;

import com.spring.mvc.admission_committee.entity.Applicant;

import java.util.List;

public interface ApplicantDao {

    List<Applicant> getAllApplicants();

    void saveApplicant(Applicant applicant);

    Applicant getApplicant(Integer applicantId);

    void deleteApplicant(Integer applicantId);
}
