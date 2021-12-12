package com.example.JazProject.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorControler {
    @GetMapping("/")
    public String deafult(){
       return  "redirect:/login";
    }
}
