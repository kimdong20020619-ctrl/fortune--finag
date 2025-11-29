package com.fortune.fortune.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "fortune/index";   // ✔ templates/fortune/index.html 을 올바르게 찾는 경로
    }
}
