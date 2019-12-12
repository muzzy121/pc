package com.muzzy.petclinic.controller;

import com.muzzy.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping({"/owner"})
public class OwnerController {
    private OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/", "", "index", "index.html"})
    public String getIndexPage(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owner/index";
    }
}
