package ru.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.test.model.User;
import ru.test.service.UserService;

@Controller
@RequestMapping("/edit")
public class EditUserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String editPage(@RequestParam(value = "id") String id, ModelMap model) {
        Long userId = Long.parseLong(id);
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "edit-page";
    }

    @PostMapping
    public String editUser(@RequestParam(value = "id") String id,
                           @RequestParam(value = "login") String login,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "email") String email) {
        userService.updateUser(new User(Long.parseLong(id), login, password, email));
        return "redirect:/";
    }
}
