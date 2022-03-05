package com.babu.ptl.ptlpetclinic.controllers;

import com.babu.ptl.ptlpetclinic.model.Owner;
import com.babu.ptl.ptlpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.List;


@RequestMapping("/owners")
@Controller
public class OwnerController {

    private static final String VIEWS_OWNER_UPDATE_OR_CREATE_FORM = "owners/createOrUpdateOwnerForm";
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"","/","index","index.html"})
    public String listOwner(Model model){

        model.addAttribute("owners", ownerService.findAll());

        return "owners/ownerindex";
    }

    @RequestMapping("/find")
    public String findOwner(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping("/owners")
    public String processFindForm (Owner owner, BindingResult result, Model model){

        if(owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
        System.out.println("let's look at the result size : " + results.size());
        if (results.isEmpty()){
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1){
            owner = results.iterator().next();
            System.out.println("I found one owner and id is " + owner.getId());
            return "redirect:owners/" + owner.getId();
        } else {
            model.addAttribute("selections", results);
            return "owners/ownerList";
        }


    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner (@PathVariable("ownerId") Long ownerId){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;

    }

    @GetMapping("/new")
    public String initCreationForm(Model model){
        model.addAttribute("owner",Owner.builder().build());
        return VIEWS_OWNER_UPDATE_OR_CREATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if(result.hasErrors()){
            return VIEWS_OWNER_UPDATE_OR_CREATE_FORM;
        } else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm (@PathVariable Long ownerId, Model model){
        model.addAttribute(ownerService.findById(ownerId));
        return VIEWS_OWNER_UPDATE_OR_CREATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable Long ownerId){
        if (result.hasErrors()){
            return VIEWS_OWNER_UPDATE_OR_CREATE_FORM;
        } else {
            owner.setId(ownerId);
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }

    }
}
