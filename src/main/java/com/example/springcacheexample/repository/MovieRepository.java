package com.example.springcacheexample.repository;

import com.example.springcacheexample.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    Movie findById(long id);
    List<Movie> findAll();

}
