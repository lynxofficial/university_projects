package com.spring.mvc.admission_committee.controller;

import com.spring.mvc.admission_committee.entity.Applicant;
import com.spring.mvc.admission_committee.service.ApplicantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mvc")
public class ApplicantMvcController {
    private final ApplicantService applicantService;

    public ApplicantMvcController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @RequestMapping("/applicants")
    public String showAllApplicants(Model model) {
        model.addAttribute("applicants", applicantService.getAllApplicants());
        return "all-applicants";
    }

    @RequestMapping("/addNewApplicant")
    public String addNewApplicant(Model model) {
        model.addAttribute("applicant", new Applicant());
        return "applicant-info";
    }

    @RequestMapping("/saveApplicant")
    public String saveApplicant(@ModelAttribute("applicant") Applicant applicant) {
        applicantService.saveApplicant(applicant);
        return "redirect:/mvc/applicants";
    }

    @RequestMapping("/updateApplicant")
    public String updateApplicant(@RequestParam("applicantId") Integer applicantId, Model model) {
        model.addAttribute("applicant", applicantService.getApplicant(applicantId));
        return "applicant-info";
    }

    @RequestMapping("/deleteApplicant")
    public String deleteApplicant(@RequestParam("applicantId") Integer applicantId) {
        applicantService.deleteApplicant(applicantId);
        return "redirect:/mvc/applicants";
    }
}
