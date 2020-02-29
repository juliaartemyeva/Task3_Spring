package ru.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.test.service.UserService;

@Controller
@RequestMapping("/")
public class UserPage {
    @Autowired
    private UserService service;

    @GetMapping
    public String getUsersPage(ModelMap model) {
        model.addAttribute("users", service.getAllUsers());
        return "users-page";
    }
}
