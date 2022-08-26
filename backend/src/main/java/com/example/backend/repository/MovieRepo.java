package com.example.backend.repository;

import com.example.backend.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class MovieRepo {

    HashMap<String, Movie> database = new HashMap();


    public List<Movie> getAllMovies() {
        ArrayList allMovies = new ArrayList();
        for (String key : database.keySet()) {
            allMovies.add(database.get(key));
        }
        return allMovies;
    }

    public Movie getMovieByName(String name) {
        for (String key: database.keySet()) {
            if (database.get(key).getTitle().equals(name))
                return database.get(key);
        }
        throw new NoSuchElementException();
    }
}
