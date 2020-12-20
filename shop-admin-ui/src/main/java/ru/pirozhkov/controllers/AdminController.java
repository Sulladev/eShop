package ru.pirozhkov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pirozhkov.entities.User;
import ru.pirozhkov.services.RoleService;
import ru.pirozhkov.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String indexPage (Model model) {
        model.addAttribute("activePage", "None");
        return "index";
    }

    @GetMapping("/users")
    public String users ( Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user_add_form";
    }
}
