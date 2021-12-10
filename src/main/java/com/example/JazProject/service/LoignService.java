package com.example.JazProject.service;

import com.example.JazProject.exceptions.NotFoundUserException;
import com.example.JazProject.objects.User;
import com.example.JazProject.repository.TwiterCloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoignService {
    private TwiterCloneRepository twiterCloneRepository;

    @Autowired
    public LoignService(TwiterCloneRepository twiterCloneRepository) {
        this.twiterCloneRepository = twiterCloneRepository;
    }

    public boolean loginCheck(String login,String password) throws NotFoundUserException{
            if(twiterCloneRepository.findBylogin(login)==null){
                throw new NotFoundUserException();
            }else {
                User user=twiterCloneRepository.findBylogin(login);
                if (user.getPassword().equals(password)){
                    return true;
                }
                else{
                    return false;
                }
            }

        }

    }

