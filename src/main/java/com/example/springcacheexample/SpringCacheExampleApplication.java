package com.example.springcacheexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCacheExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCacheExampleApplication.class, args);
    }


}
