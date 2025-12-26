package com.portella.front.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeContrller {
       @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Dashboard");
        model.addAttribute("message", "Front-end Spring Boot rodando com sucesso 🚀");
        return "dashboard";
    }
}
