package com.example.backend.controller;

import com.example.backend.model.ApiMovie;
import com.example.backend.model.Movie;
import com.example.backend.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public String getAllMovies(){
        return "Hallo";
    }

    @GetMapping("/{name}")
    public ApiMovie getMovieByName(@PathVariable String name){
        return movieService.getMovieByName(name);
    }

}
