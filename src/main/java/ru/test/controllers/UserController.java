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
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String getUsersPage(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users-page";
    }

    @GetMapping(value = "/new")
    public String getForm() {
        return "users-form";
    }

    @PostMapping(value = "/new")
    public String addNewUser(@RequestParam(value = "login") String login,
                             @RequestParam(value = "password") String password,
                             @RequestParam(value = "email") String email) {
        userService.addUser(new User(login, password, email));
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam(value = "id") String id, ModelMap model) {
        Long userId = Long.parseLong(id);
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "edit-page";
    }

    @PostMapping("/edit")
    public String editUser(@RequestParam(value = "id") String id,
                           @RequestParam(value = "login") String login,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "email") String email) {
        userService.updateUser(new User(Long.parseLong(id), login, password, email));
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") String id) {
        Long userId = Long.parseLong(id);
        userService.deleteUser(userId);
        return "redirect:/";
    }
}
