package ru.pirozhkov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MainController {

    public String indexPage (Model model) {
        model.addAttribute("activePage", "None");
        return "index";
    }
}
