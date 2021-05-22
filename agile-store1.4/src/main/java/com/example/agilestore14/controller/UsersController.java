package com.example.agilestore14.controller;

import com.example.agilestore14.entities.Users;
import com.example.agilestore14.form.UsersForm;
import com.example.agilestore14.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


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
    public String handleRegistrationForm(@ModelAttribute("UsersForm") final UsersForm usersForm, Users users) {
        userService.save(users);
        return "registerNewUser";
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
