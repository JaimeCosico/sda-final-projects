package com.example.agilestore15.controller;

import com.example.agilestore15.entities.Users;
import com.example.agilestore15.form.UsersForm;
import com.example.agilestore15.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class UsersController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(final ModelMap modelMap){
        modelMap.addAttribute("UsersForm",new UsersForm());
        return "registerNewUser";
    }

    @PostMapping("/register")
    public String handleRegistrationForm(@Valid @ModelAttribute("UsersForm") final UsersForm usersForm, Users users) {
        userService.save(userService.registerNewUser(users));
        return "registerNewUserSuccessful";
    }

    /*@GetMapping("/registration/view")
    public String viewNewUsers(@ModelAttribute())
        List<Users> listUsers =  userService.showAllUsers();
        model.addAttribute("viewUsers", listUsers);
        return listUsers.toString();
    }*/

    /*@RequestMapping("/registration/create")
    public String createNewUsers(@RequestParam(name = "registerNewUser",
            required = true)String name, Model model){
        Users users = new Users();
        model.addAttribute("registerNewUser", users);
        return "registerNewUser";
    }

    @RequestMapping(value = "/registration/save", method = RequestMethod.POST)
    public String saveNewUsers(@ModelAttribute("registerNewUser")Users users) {
        userService.saveNewUsers(users);
        return users.toString();
    }*/
}
