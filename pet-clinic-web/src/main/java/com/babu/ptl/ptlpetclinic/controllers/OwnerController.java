package com.babu.ptl.ptlpetclinic.controllers;

import com.babu.ptl.ptlpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","index","index.html"})
    public String listOwner(Model model){

        model.addAttribute("owners", ownerService.findAll());

        return "owners/ownerindex";
    }

    @RequestMapping("/find")
    public String findOwner(){
        return "notimplemented";
    }
}
