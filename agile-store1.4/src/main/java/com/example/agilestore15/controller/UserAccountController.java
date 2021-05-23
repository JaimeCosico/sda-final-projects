package com.example.agilestore15.controller;

import com.example.agilestore15.entities.UserAccount;
import com.example.agilestore15.form.UsersAccountForm;
import com.example.agilestore15.services.UserAccountService;
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

    @GetMapping("/register-1")
    public String showRegistrationForm(final ModelMap modelMap){
        modelMap.addAttribute("UsersAccountForm",new UsersAccountForm());
        return "registerNewUserAccount";
    }

    @PostMapping("/register-1")
    public String handleRegistrationForm(@Valid @ModelAttribute("UsersAccountForm") final UsersAccountForm usersAccountForm, UserAccount userAccount) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userAccount.getPassword());
        userAccount.setPassword(encodedPassword);
        userAccountService.save(userAccountService.registerNewUserAccount(userAccount));
        return "registerNewUserAccountSuccessful";
    }
}
