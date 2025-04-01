package com.example.Jour02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String showView(Model model) {
        model.addAttribute("message", "Bonjour, ceci est un message affiché avec Thymeleaf !");
        return "view";
    }
}