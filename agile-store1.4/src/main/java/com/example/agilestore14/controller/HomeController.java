package com.example.agilestore14.controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String viewHomepage(final ModelMap modelMap){
        modelMap.addAttribute("roleMessage", "This is the Homepage");
        return "Home";
    }
}
