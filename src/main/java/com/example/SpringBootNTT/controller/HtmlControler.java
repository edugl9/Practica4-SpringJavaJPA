package com.example.SpringBootNTT.controller;

import com.example.SpringBootNTT.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlControler {
    @Autowired
    private StudentService service;

    @GetMapping("/homePage")
    public String homePage(Model model){
        model.addAttribute("yoSoy", "eduardo");
        return "home";
        //model.addAllAttributes("students");
    }

    @GetMapping("/listaalumnos")
    public String listaalumnos(Model model){
        model.addAttribute("students", service.getLista());
        return "alumnos";
        //model.addAllAttributes("students");
    }
}
