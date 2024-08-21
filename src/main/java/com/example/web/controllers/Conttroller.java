package com.example.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Conttroller {
    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }
}
