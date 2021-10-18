package com.example.springlesson3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {


    @RequestMapping("/")
    public String helloWorld(Model model) {
        return "index";
    }
}
