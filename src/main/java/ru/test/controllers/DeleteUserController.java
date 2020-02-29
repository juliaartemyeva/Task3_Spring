package ru.test.controllers;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import ru.test.service.UserService;

@Controller
@RequestMapping("/delete")
public class DeleteUserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String deleteUser(@RequestParam(value = "id") String id) {
        Long userId = Long.parseLong(id);
        userService.deleteUser(userId);
        return "redirect:/";
    }
}
