package com.example.agilestore15.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String viewHomepage(final ModelMap modelMap){
        modelMap.addAttribute("roleMessage", "This is the Homepage");
        return "home";
    }
}
