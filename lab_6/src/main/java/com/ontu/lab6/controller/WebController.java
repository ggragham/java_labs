package com.ontu.lab6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class WebController {
    @RequestMapping(value = "/index")
    public String index(Model model) {
        String[] board = {
            "X", "O", "-",
            "O", "X", "-",
            "-", "-", "X"
        };
        
        model.addAttribute("board", board);
        return "index";
    }
}
