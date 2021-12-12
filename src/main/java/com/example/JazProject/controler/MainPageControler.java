package com.example.JazProject.controler;

import com.example.JazProject.objects.Tweets;
import com.example.JazProject.repository.TwettRepository;
import com.example.JazProject.service.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainPageControler {
    MainPageService mainPageService;

    @Autowired
    public MainPageControler(MainPageService mainPageService) {
        this.mainPageService=mainPageService;
    }


    @GetMapping("/mainPage")
    public String mainPage(Model model) {
       List<Tweets> userTweets=mainPageService.getAllPost();
        model.addAttribute("tweet", userTweets);
        return "MainPage";
    }
}
