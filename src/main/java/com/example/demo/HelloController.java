package com.example.demoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot DevOps Project!";
    }
    
    @GetMapping("/health")
    public String health() {
        return "Application is running smoothly!";
    }
}