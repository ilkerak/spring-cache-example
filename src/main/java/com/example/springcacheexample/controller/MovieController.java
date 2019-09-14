package com.example.springcacheexample.controller;

import com.example.springcacheexample.model.Movie;
import com.example.springcacheexample.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/get/{id}")
    public Movie get (@PathVariable("id") long id) {
        return movieService.get(id);
    }

    @GetMapping("/getAll")
    public List<Movie> getAll () {
        return movieService.getAll();
    }

    @PostMapping("/save")
    public Movie save (@RequestBody Movie movie) {
        return movieService.saveOrUpdate(movie);
    }

    @PostMapping("/update")
    public Movie update (@RequestBody Movie movie) {
        return movieService.saveOrUpdate(movie);
    }

    @PostMapping("/delete/{id}")
    public void delete (@PathVariable("id") long id) {
        movieService.delete(id);
    }
}
