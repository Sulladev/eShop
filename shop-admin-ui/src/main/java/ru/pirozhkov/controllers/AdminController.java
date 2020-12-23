package ru.pirozhkov.controllers;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.pirozhkov.entities.Role;
import ru.pirozhkov.entities.User;

import ru.pirozhkov.services.RoleService;
import ru.pirozhkov.services.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller

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

    @GetMapping("/users/add")
    public String addUser(Model model) {
        model.addAttribute("userForm", new User());
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        model.addAttribute("role", new Role());
        return "user_add_form";
    }


    @PostMapping("/users/add")
    public String addUser(@Valid @ModelAttribute("userForm") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_add_form";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        User u = userService.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " doesn't exists (for edit)"));
        model.addAttribute("user", u);
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        model.addAttribute("role", new Role());
        return "users_edit_form";
    }


    @PostMapping("/edit")
    public String showEditForm(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUserById(@PathVariable ("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

}
