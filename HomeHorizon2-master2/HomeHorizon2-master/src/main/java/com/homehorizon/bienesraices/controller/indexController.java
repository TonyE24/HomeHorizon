package com.homehorizon.bienesraices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @GetMapping("/")
    public String login(){
        return "redirect:/login";
    }
}
