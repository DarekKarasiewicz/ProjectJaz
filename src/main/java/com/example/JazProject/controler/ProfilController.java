package com.example.JazProject.controler;

import com.example.JazProject.objects.Tweets;
import com.example.JazProject.objects.User;
import com.example.JazProject.repository.TwettRepository;
import com.example.JazProject.repository.UserRepository;
import com.example.JazProject.security.MyUserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProfilController  {
    UserRepository userRepository;
    TwettRepository twettRepository;

    public ProfilController(UserRepository userRepository, TwettRepository twettRepository) {
        this.userRepository = userRepository;
        this.twettRepository = twettRepository;
    }

    @GetMapping("/profil")
    public String profilPage(@AuthenticationPrincipal MyUserPrincipal user, Model model){
        User user1=new User(user.getId(),user.getUsername(),user.getPassword());
        List<Tweets> userTweets=twettRepository.findByuser_id(user1.getId());
        model.addAttribute("User",user1);
        model.addAttribute("tweet", userTweets);

        return "Profil.html";
}

}
