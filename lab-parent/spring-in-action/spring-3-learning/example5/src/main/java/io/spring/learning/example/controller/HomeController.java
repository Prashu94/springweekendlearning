package io.spring.learning.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"", "/", "home"})
    public String displayHomePage(Model model){
//        model.addAttribute("username", "Prashant Bhat");
        return "home.html";
    }
}
