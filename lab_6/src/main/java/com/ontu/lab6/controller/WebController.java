package com.ontu.lab6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class WebController {
    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("variable1", "First Variable");
        model.addAttribute("variable2", "Second Variable");
        return "index";
    }
}
