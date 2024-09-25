package com.example.requestparammvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class WelcomeController {
    //curl "http://localhost:8080/greet?name=Thomas"
    @GetMapping("/greet")
    public String welcome(@RequestParam(defaultValue = "John") Optional<String> name) {
        return "Hello !" + name.orElse(null) + " . ";
    }

    //curl "http://localhost:8080/info"
    //curl "http://localhost:8080/info?country=UK" /*change country*/
    @GetMapping("/info")
    public String info(@RequestParam(value = "country", required = false, defaultValue = "USA")String country,
                       @RequestParam(value = "age", required = false, defaultValue = "20")int age,
                       @RequestParam(value = "hobby", required = false, defaultValue = "Riding")String hobby) {
        return "Country :: %s , Age :: %d, Hobby :: %s ."
                .formatted(country,
                        age,
                        hobby);
    }
}
