package com.example.JazProject.controler;
import com.example.JazProject.exceptions.NotFoundUserException;

import com.example.JazProject.objects.User;

import com.example.JazProject.service.LoignService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginControler {

    private LoignService loignService;

    public LoginControler(LoignService loignService) {
        this.loignService = loignService;
    }

    @GetMapping("/login")
    public String login( ){
        return "login";
    }

}
