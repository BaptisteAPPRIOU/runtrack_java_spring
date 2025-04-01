package com.example.Jour02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "zeojpruhougvoezuvozuvuzk!";
    }

}