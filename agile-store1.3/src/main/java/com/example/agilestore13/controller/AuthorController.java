package com.example.agilestore13.controller;

import com.example.agilestore13.entities.Author;
import com.example.agilestore13.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @RequestMapping("/viewAuthorPage")
    public String viewAuthorPage(@RequestParam(name = "listAuthor",
            required = false)String name, Model model){
        List<Author> listAuthor =  authorService.listAllAuthor();
        model.addAttribute("listAuthor", listAuthor);
        return "viewAuthorPage";
    }

    @RequestMapping("/createNewAuthor")
    public String createNewAuthor(@RequestParam(name = "createAuthor",
            required = false)String name, Model model){
        Author author = new Author();
        model.addAttribute("createAuthor", author);
        return "createNewAuthor";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAuthor(@ModelAttribute("createAuthor") Author author) {
        authorService.save(author);
        return "saveAuthor";
    }

    /*@GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }*/
}
