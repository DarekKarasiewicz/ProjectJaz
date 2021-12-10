package com.example.JazProject.controler;
import com.example.JazProject.exceptions.NotFoundUserException;
import com.example.JazProject.objects.User;
import com.example.JazProject.repository.TwiterCloneRepository;
import com.example.JazProject.service.LoignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginControler {

    private LoignService loignService;
    private boolean foo=false;

    public LoginControler(LoignService loignService) {
        this.loignService = loignService;
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("foo", foo);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user ) throws NotFoundUserException {
       if (loignService.loginCheck(user.getLogin(), user.getPassword())){
           return "redirect:/mainPage";
       }
       else{
           foo=true;
           return "redirect:/login";
       }

    }
}
