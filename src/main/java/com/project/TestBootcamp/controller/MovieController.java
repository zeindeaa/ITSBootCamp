package com.project.TestBootcamp.controller;

import com.project.TestBootcamp.dto.MovieRequest;
import com.project.TestBootcamp.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService=movieService;
    }

    @PostMapping(value = "/add")
    public String addMovie(@RequestBody MovieRequest request) {
        String output = movieService.save(request);
        return output;
    }

    @GetMapping(value = "/get/{id}")
    public String getDataMovieById(@PathVariable Long id){
        return movieService.get(id);
    }

}
