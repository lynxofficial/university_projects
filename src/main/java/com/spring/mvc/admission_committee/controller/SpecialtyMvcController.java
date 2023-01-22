package com.spring.mvc.admission_committee.controller;

import com.spring.mvc.admission_committee.entity.Applicant;
import com.spring.mvc.admission_committee.entity.Specialty;
import com.spring.mvc.admission_committee.service.ApplicantService;
import com.spring.mvc.admission_committee.service.SpecialtyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mvc")
public class SpecialtyMvcController {
    private final SpecialtyService specialtyService;
    private final ApplicantService applicantService;

    public SpecialtyMvcController(SpecialtyService specialtyService, ApplicantService applicantService) {
        this.specialtyService = specialtyService;
        this.applicantService = applicantService;
    }

    @RequestMapping("/specialties")
    public String showAllSpecialties(Model model) {
        model.addAttribute("specialties", specialtyService.getAllSpecialties());
        return "all-specialties";
    }

    @RequestMapping("/addNewSpecialty")
    public String addNewSpecialty(Model model) {
        model.addAttribute("specialty", new Specialty());
        return "specialty-info";
    }

    @RequestMapping("/saveSpecialty")
    public String saveSpecialty(@ModelAttribute Specialty specialty) {
        specialtyService.saveSpecialty(specialty);
        return "redirect:/mvc/specialties";
    }

    @RequestMapping("/updateSpecialty")
    public String updateSpecialty(@RequestParam Integer specialtyId, Model model) {
        model.addAttribute("specialty", specialtyService.getSpecialty(specialtyId));
        return "specialty-info";
    }

    @RequestMapping("/deleteSpecialty")
    public String deleteSpecialty(@RequestParam Integer specialtyId) {
        specialtyService.deleteSpecialty(specialtyId);
        return "redirect:/mvc/specialties";
    }

    @RequestMapping("/addSpecialtyToApplicant")
    public String addSpecialtyToApplicant(@RequestParam("applicantId") Integer applicantId, Model model) {
        model.addAttribute("specialties", specialtyService.getAllSpecialties());
        model.addAttribute("applicant", applicantService.getApplicant(applicantId));
        return "adding-specialties-to-applicant";
    }

    @RequestMapping("/addSelectedSpecialtyToApplicant")
    public String addSelectedSpecialtyToApplicant(@RequestParam("specialtyId") Integer specialtyId,
                                                  @RequestParam("applicantId") Integer applicantId) {
        Applicant applicant = applicantService.getApplicant(applicantId);
        applicant.addSpecialty(specialtyService.getSpecialty(specialtyId));
        applicantService.saveApplicant(applicant);
        return "redirect:/mvc/applicants";
    }
}
