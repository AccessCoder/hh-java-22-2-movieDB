package com.example.backend.service;

import com.example.backend.model.ApiMovie;
import com.example.backend.model.Movie;
import com.example.backend.repository.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {


    private final MovieRepo repo;

    public List<Movie> getAllMovies(){
        return repo.getAllMovies();
    }

    WebClient webClient = WebClient.create("http://www.omdbapi.com/");

    public ApiMovie getMovieByName(String name){
        ApiMovie response = webClient.get()
                .uri("?apikey=f42160a1&s="+name)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .toEntity(ApiMovie.class)
                .block()
                .getBody();
        return response;
    }



}
