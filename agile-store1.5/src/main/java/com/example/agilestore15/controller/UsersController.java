package com.example.agilestore15.controller;

import com.example.agilestore15.entities.Users;
import com.example.agilestore15.form.UsersForm;
import com.example.agilestore15.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
public class UsersController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(final ModelMap modelMap,UsersForm usersForm){
        modelMap.addAttribute("usersForm",usersForm);
        return "registerNewUser";
    }

    @PostMapping("/register")
    public String handleRegistrationForm(@Valid @ModelAttribute("usersForm") final UsersForm usersForm,Errors errors, Model model) {
        Users existedUsername= userService.findUsersByEmail(usersForm);
        if(existedUsername!=null){
            model.addAttribute("message","This email already exists!");
        }else{
            if(!errors.hasErrors()){
                model.addAttribute("message","Registration Successful!");
                userService.save(userService.registerNewUser(usersForm));
                return "registerNewUserSuccessful";
            }
        }
        return "registerNewUser";
    }
}
