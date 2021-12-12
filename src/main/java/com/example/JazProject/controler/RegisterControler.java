package com.example.JazProject.controler;

import com.example.JazProject.exceptions.UserExistException;
import com.example.JazProject.objects.User;
import com.example.JazProject.service.RegisterService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterControler {
    RegisterService registerService;

    public RegisterControler(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/register")
    public String createNewUser(Model model){
        model.addAttribute("user",new User());
        return "Register";
    }
    @PostMapping("/register")
    public String createNewUser(@ModelAttribute User user) throws UserExistException {
        registerService.saveNewUser(user);
        return "redirect:/login";
    }
}
