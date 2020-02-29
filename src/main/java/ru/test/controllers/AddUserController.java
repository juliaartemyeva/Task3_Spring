package ru.test.controllers;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import ru.test.model.User;
        import ru.test.service.UserService;

@Controller
@RequestMapping("/new")
public class AddUserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getForm() {
        return "users-form";
    }

    @PostMapping

    public String addNewUser(@RequestParam(value = "login") String login,
                             @RequestParam(value = "password") String password,
                             @RequestParam(value = "email") String email) {
        userService.addUser(new User(login, password, email));
        return "redirect:/";
    }
}
