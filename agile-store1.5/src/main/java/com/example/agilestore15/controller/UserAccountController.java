package com.example.agilestore15.controller;

import com.example.agilestore15.entities.Users;
import com.example.agilestore15.form.UsersAccountForm;
import com.example.agilestore15.form.UsersForm;
import com.example.agilestore15.services.UserAccountService;
import com.example.agilestore15.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class UserAccountController {
    @Autowired
    UserAccountService userAccountService;

    @Autowired
    UserService userService;

    @GetMapping("/register-1")
    public String showRegistrationForm(final ModelMap modelMap, UsersForm users){
        modelMap.addAttribute("UsersAccountForm",new UsersAccountForm());
        return "registerNewUserAccount";
    }

    @PostMapping("/register-1")
    public String handleRegistrationForm(@Valid @ModelAttribute("UsersAccountForm") final UsersAccountForm usersAccountForm) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(usersAccountForm.getPassword());
        usersAccountForm.setPassword(encodedPassword);
        userAccountService.save(userAccountService.registerNewUserAccount(usersAccountForm));
        return "registerNewUserAccountSuccessful";
    }
}
