package com.example.backend.controller;

import com.example.backend.model.Movie;
import com.example.backend.model.MovieDetail;
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
    public List<Movie> getMoviesByTitle(@RequestParam(required = false) String title){

        return movieService.getMoviesByTitle(title);
    }

    @GetMapping("/{id}")
    public MovieDetail getMovieById(@PathVariable String id){

        return movieService.getMovieById(id);
    }

    @GetMapping("/favorite")
    public List<Movie> getFavoriteMovies(){
        return movieService.getFavoriteMovies();
    }

    @PutMapping("/favorite/{id}")
    public Movie addFavoriteMovie(@PathVariable String id){
        return movieService.addFavoriteMovie(id);
    }

    @DeleteMapping("/favorite/{id}")
    public void deleteFavoriteMovie(@PathVariable String id){
        movieService.deleteFavoriteMovie(id);
    }

}
