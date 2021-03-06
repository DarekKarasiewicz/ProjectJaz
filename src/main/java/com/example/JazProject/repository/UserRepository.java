package com.example.JazProject.repository;

import com.example.JazProject.objects.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findBylogin(String login);
    User findByid(int id);
}
