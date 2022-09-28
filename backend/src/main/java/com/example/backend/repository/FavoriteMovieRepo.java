package com.example.backend.repository;


import com.example.backend.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class FavoriteMovieRepo {

    Map<String, Movie> favoriteMovies = new HashMap<>();

    public List<Movie> getAllFavoriteMovies() {
        return new ArrayList<>(favoriteMovies.values());
    }

    public Movie addFavoriteMovie(Movie movie){
        favoriteMovies.put(movie.getId(), movie);

        return movie;
    }

    public void deleteFavoriteMovie(String id) {
        favoriteMovies.remove(id);
    }
}
