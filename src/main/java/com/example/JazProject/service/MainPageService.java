package com.example.JazProject.service;

import com.example.JazProject.objects.Tweets;
import com.example.JazProject.repository.TwettRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainPageService {
    TwettRepository twettRepository;

    @Autowired
    public MainPageService(TwettRepository twettRepository) {
        this.twettRepository = twettRepository;
    }

    public List<Tweets> getAllPost(){
        List<Tweets> userTweets=twettRepository.findAll();
      return  userTweets;
    }


}
