package com.example.agilestore14.controller;

import com.example.agilestore14.entities.Author;
import com.example.agilestore14.entities.UserAccount;
import com.example.agilestore14.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class UserAccountController {
    @Autowired
    UserAccountService userAccountService;

    @RequestMapping("/registration_1/view")
    public String viewAuthorPage(@RequestParam(name = "listUserAccount",
            required = false)String name, Model model){
        List<UserAccount> listUserAccount =  userAccountService.showAllUserAccount();
        model.addAttribute("listUserAccount", listUserAccount);
        return listUserAccount.toString();
    }

    @RequestMapping("/registration_1/create")
    public String createNewAuthor(@RequestParam(name = "registerNewUserAccount",
            required = false)String name, Model model){
        UserAccount userAccount = new UserAccount();
        model.addAttribute("registerNewUserAccount", userAccount);
        return "registerNewUserAccount";
    }

    @RequestMapping(value = "/registration1_save", method = RequestMethod.POST)
    public String saveAuthor(@ModelAttribute("registerNewUserAccount") UserAccount userAccount) {
        userAccountService.saveNewUserAccount(userAccount);
        return userAccount.toString();
    }
}
