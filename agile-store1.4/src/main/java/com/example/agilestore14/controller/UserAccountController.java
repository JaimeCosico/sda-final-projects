package com.example.agilestore14.controller;

import com.example.agilestore14.entities.UserAccount;
import com.example.agilestore14.form.UsersAccountForm;
import com.example.agilestore14.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class UserAccountController {
    @Autowired
    UserAccountService userAccountService;

    @GetMapping("/register-1")
    public String showRegistrationForm(final ModelMap modelMap){
        modelMap.addAttribute("UsersAccountForm",new UsersAccountForm());
        return "registerNewUserAccount";
    }

    @PostMapping("/register-1")
    public String handleRegistrationForm(@Valid @ModelAttribute("UsersAccountForm") final UsersAccountForm usersAccountForm, UserAccount userAccount) {
        userAccountService.save(userAccount);
        return "registerNewUserSuccessful";
    }
}
