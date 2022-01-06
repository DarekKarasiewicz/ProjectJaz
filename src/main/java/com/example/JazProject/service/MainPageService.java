package com.example.JazProject.service;

import com.example.JazProject.objects.Tweets;
import com.example.JazProject.objects.User;
import com.example.JazProject.repository.TwettRepository;
import com.example.JazProject.repository.UserRepository;
import com.example.JazProject.security.MyUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class MainPageService {
    TwettRepository twettRepository;
    UserRepository userRepository;

    @Autowired
    public MainPageService(TwettRepository twettRepository,UserRepository userRepository) {
        this.userRepository=userRepository;
        this.twettRepository = twettRepository;
    }

    public List<Tweets> getAllPost(){
        List<Tweets> userTweets=twettRepository.findAll();
      return  userTweets;
    }


    public void saveTweet(Tweets tweets, MyUserPrincipal user){
        User user1=new User(user.getId(),user.getUsername(),user.getPassword());
        tweets.setUser(user1);
        String dateNow= LocalDate.now() + " "+String.valueOf(LocalTime.now().getHour())+ ":"+ String.valueOf(LocalTime.now().getMinute());
        tweets.setData(dateNow);

        twettRepository.save(tweets);
    }


}
