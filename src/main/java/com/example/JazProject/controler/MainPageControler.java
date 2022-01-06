package com.example.JazProject.controler;


import com.example.JazProject.objects.Tweets;
import com.example.JazProject.objects.User;
import com.example.JazProject.repository.TwettRepository;
import com.example.JazProject.repository.UserRepository;
import com.example.JazProject.security.MyUserPrincipal;
import com.example.JazProject.service.MainPageService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


import java.util.List;

@Controller
@NoArgsConstructor
public class MainPageControler {
    MainPageService mainPageService;

    @Autowired
    public MainPageControler(MainPageService mainPageService) {
        this.mainPageService=mainPageService;
    }

    @GetMapping("/mainPage")
    public String mainPage(Model model, @AuthenticationPrincipal MyUserPrincipal user) {

//        System.out.println(user.getUsername());
//        System.out.println(user.getPassword());
//        System.out.println(user.getId());

        List<Tweets> userTweets=mainPageService.getAllPost();
        model.addAttribute("tweet",userTweets);
        model.addAttribute("tweets", new Tweets());
        return "MainPage";
    }

    @PostMapping("/mainPage")
    public String mainPage(@ModelAttribute Tweets tweets,@AuthenticationPrincipal MyUserPrincipal user){

        mainPageService.saveTweet(tweets,user);
        return "redirect:/mainPage";
    }

}
