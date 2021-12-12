package com.example.JazProject.service;

import com.example.JazProject.exceptions.NotFoundUserException;
import com.example.JazProject.objects.User;
import com.example.JazProject.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoignService {
    private UserRepository userRepository;

    @Autowired
    public LoignService( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean loginCheck(String login,String password) throws NotFoundUserException{
            if(userRepository.findBylogin(login)==null){
                throw new NotFoundUserException();
            }else {
                User user=userRepository.findBylogin(login);
                if (user.getPassword().equals(password)){
                    return true;
                }
                else{
                    return false;
                }
            }

        }

    }

