package com.example.backend.service;

import com.example.backend.api.MovieApiService;
import com.example.backend.model.Movie;
import com.example.backend.repository.FavoriteMovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieApiService movieApiService;
    private final FavoriteMovieRepo favoriteMovieRepo;

    public List<Movie> getAllMovies(){
        // Search with some default query
        return movieApiService.getMoviesByName("java");
    }

    public List<Movie> getMoviesByName(String name) {
        return movieApiService.getMoviesByName(name);
    }

    public List<Movie> getFavoriteMovies() {
        return favoriteMovieRepo.getAllFavoriteMovies();

    }

    public Movie addFavoriteMovie(String id) {
        Movie foundMovie = movieApiService.getMovieById(id);

        return favoriteMovieRepo.addFavoriteMovie(foundMovie);
    }

    public void deleteFavoriteMovie(String id) {
        favoriteMovieRepo.deleteFavoriteMovie(id);
    }

    public Movie getMovieById(String id) {
        return movieApiService.getMovieById(id);
    }
}
