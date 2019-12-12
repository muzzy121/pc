package com.muzzy.petclinic.controller;

import com.muzzy.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/vet"})
public class VetController {
    private VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/", "", "index", "index.html"})
    public String getIndexPage(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vet/index";
    }
}
