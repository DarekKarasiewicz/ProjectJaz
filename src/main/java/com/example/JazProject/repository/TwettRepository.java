package com.example.JazProject.repository;

import com.example.JazProject.objects.Tweets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TwettRepository extends CrudRepository<Tweets,Integer> {
    List<Tweets> findAll();
    List<Tweets> findByuser_id(int user_id);
}
