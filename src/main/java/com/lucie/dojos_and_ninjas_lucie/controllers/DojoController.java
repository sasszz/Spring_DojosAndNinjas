package com.lucie.dojos_and_ninjas_lucie.controllers;
import com.lucie.dojos_and_ninjas_lucie.models.Dojo;
import com.lucie.dojos_and_ninjas_lucie.models.Ninja;
import com.lucie.dojos_and_ninjas_lucie.services.DojoService;
import com.lucie.dojos_and_ninjas_lucie.services.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class DojoController {

    private final DojoService dojoService;

    public DojoController(DojoService dojoService) {
        this.dojoService = dojoService;
    }

    //! CREATE AND SHOW ALL
    @GetMapping("/dojos")
    public String newDojo(@ModelAttribute(value = "dojo") Dojo dojo, Model model) {
        model.addAttribute("dojos", dojoService.getAll());
        return "/dojos/dojos.jsp";
    }

    @PostMapping("/dojos")
    public String createDojo(@Valid @ModelAttribute(value = "dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "/dojos/dojos.jsp";
        } else {
            dojoService.create(dojo);
            return "redirect:/dojos";
        }
    }

    //! UPDATE DOJO
    @GetMapping("/dojos/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.getOne(id);
        model.addAttribute("dojo", dojo);
        return "/dojos/update.jsp";
    }

    @PutMapping(value="/dojos/{id}")
    public String update(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "/dojos/update.jsp";
        } else {
            dojoService.update(dojo);
            return "redirect:/dojos";
        }
    }

//    ! DELETE DOJO
    @DeleteMapping("/dojos/{id}")
    public String destroy(@PathVariable("id") Long id) {
        dojoService.delete(id);
        return "redirect:/dojos";
    }

    //! READ SHOW ONE DOJO

    @GetMapping("/dojos/{id}")
    public String showDojo(Model model, @PathVariable("id") Long id) {
        Dojo dojo = dojoService.getOne(id);
        model.addAttribute("dojo", dojo);
        return "/dojos/show.jsp";
    }

//    //! CREATE NINJA
//
//    @GetMapping("/ninjas")
//    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
//        model.addAttribute("dojos", dojoService.getAll());
//        return "/ninjas/new.jsp";
//    }
//
//    @PostMapping("/ninjas")
//    public String createNinja(@ModelAttribute("ninja") Ninja ninja, BindingResult result) {
//        String id = String.valueOf(ninja.getDojo().getId());
//        if (result.hasErrors()) {
//            return "/ninjas/new.jsp";
//        } else {
//            ninjaService.create(ninja);
//            return String.format("redirect:/dojos/%s", id);
//        }



}

