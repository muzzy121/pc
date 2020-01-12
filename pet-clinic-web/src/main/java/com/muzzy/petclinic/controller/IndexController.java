package com.muzzy.petclinic.controller;

import com.muzzy.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    VetService vetService;

    @Autowired
    public IndexController(VetService vetService) {
        this.vetService = vetService;
    }


    @RequestMapping({"/", "", "index", "index.html"})
    public String getIndexPage() {

        return "index";
    }
    @RequestMapping("/oups")
    public String underConstruct(){
        return "underconstruction";
    }
}
