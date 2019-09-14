package com.example.springcacheexample.services;

import com.example.springcacheexample.model.Movie;
import com.example.springcacheexample.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @CachePut(value = "get-movie", key = "#movie.id")
    @CacheEvict(cacheNames = "getAll-movie", allEntries = true)
    public Movie saveOrUpdate(Movie movie) {
        return movieRepository.save(movie);
    }

    @Cacheable(value = "get-movie", key = "#id")
    public Movie get(long id) {
        log.info("Waiting for 3 seconds...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
        return movieRepository.findById(id);
    }

    @Cacheable(value = "getAll-movie")
    public List<Movie> getAll() {
        log.info("Waiting for 3 seconds...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
        return movieRepository.findAll();
    }

    @Caching(evict = {
            @CacheEvict(value = "getAll-movie", allEntries = true),
            @CacheEvict(value = "get-movie", key = "#id")
    })
    public void delete(long id) {
        movieRepository.deleteById(id);
    }
}
