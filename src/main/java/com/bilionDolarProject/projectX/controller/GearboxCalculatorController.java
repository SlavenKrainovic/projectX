package com.bilionDolarProject.projectX.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GearboxCalculatorController {


    @GetMapping("/gearbox/calculate")
    public String string (Model model){
        Integer maxRpm = 1000;
        model.addAttribute("title", maxRpm);
        model.addAttribute("inputString", "");
        return "GearCalculatorController";
    }

    @PostMapping("/submit")
    public String submitForm (@RequestParam("inputString") String inputString, Model model){
        model.addAttribute("title", inputString);
        return "GearCalculatorController";
    }

}
