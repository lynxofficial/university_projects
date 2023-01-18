package com.spring.mvc.admission_committee.controller;

import com.spring.mvc.admission_committee.entity.Specialty;
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

    public SpecialtyMvcController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
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
}
