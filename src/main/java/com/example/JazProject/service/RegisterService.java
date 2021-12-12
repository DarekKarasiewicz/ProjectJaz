package com.example.JazProject.service;

import com.example.JazProject.exceptions.UserExistException;
import com.example.JazProject.objects.User;
import com.example.JazProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class RegisterService {
    private UserRepository userRepository;

    @Autowired
    public RegisterService( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveNewUser(User user) throws UserExistException {
        if(userRepository.findBylogin(user.getLogin()) != null){
            throw new UserExistException();
        }
        else  {
            userRepository.save(user);
        }

    }
}
