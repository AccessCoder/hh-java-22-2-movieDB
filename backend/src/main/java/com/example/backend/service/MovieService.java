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

    public List<Movie> getMoviesByTitle(String title) {
        if (title == null){
            // Search with some default query
            title = "java";
        }

        return movieApiService.getMoviesByTitle(title);
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
