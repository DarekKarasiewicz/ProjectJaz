package com.example.JazProject.repository;

import com.example.JazProject.objects.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findBylogin(String login);


}
