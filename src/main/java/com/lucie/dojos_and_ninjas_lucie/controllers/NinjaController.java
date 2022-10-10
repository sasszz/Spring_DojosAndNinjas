package com.lucie.dojos_and_ninjas_lucie.controllers;

import com.lucie.dojos_and_ninjas_lucie.models.Ninja;
import com.lucie.dojos_and_ninjas_lucie.services.DojoService;
import com.lucie.dojos_and_ninjas_lucie.services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class NinjaController {
    @Autowired
    NinjaService service;
    @Autowired
    DojoService dojoService;

    @GetMapping("/ninjas")
    String createForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
        model.addAttribute("dojos", dojoService.getAll());
        return "/ninjas/new.jsp";
    }
    @PostMapping("/ninjas/new")
    String create(@ModelAttribute("ninja") Ninja ninja) {
        service.create(ninja);
        return "redirect:/dojos";
    }
    //    @GetMapping("/ninjas")
//    String showAll(Model model) {
//        List<Ninja> ninjas = service.getAll();
//        model.addAttribute("ninjas", ninjas);
//        return "ninjas.jsp";
//    }
//    @GetMapping("/ninjas/{id}")
//    String showOne(@PathVariable Long id, Model model) {
//        Ninja ninja = service.getOne(id);
//        model.addAttribute("ninja", ninja);
//        return "showNinja.jsp";
//    }
//    @GetMapping("/ninjas/{id}/edit")
//    String updateForm(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("ninja", service.getOne(id));
//        return "updateNinja.jsp";
//    }
//    @PutMapping("/ninjas/{id}")
//    String update(
//            @Valid
//            @ModelAttribute("ninja") Ninja ninja,
//            BindingResult result) {
//        if (result.hasErrors()) {
//            return "updateNinja.jsp";
//        } else {
//            service.update(ninja);
//            return "redirect:/ninjas";
//        }
//    }
//    @DeleteMapping("/ninjas/{id}")
//    String delete(@PathVariable("id") Long id) {
//        service.delete(id);
//        return "redirect:/ninjas";
//    }
}