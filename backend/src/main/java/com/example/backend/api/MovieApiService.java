package com.example.backend.api;

import com.example.backend.api.model.ApiMovie;
import com.example.backend.model.Movie;
import com.example.backend.api.model.OmdbResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class MovieApiService {

    @Value("${omdb.api.key}")
    public String API_KEY;

    WebClient webClient = WebClient.create("http://www.omdbapi.com/");

    public Movie getMovieById(String id) {
        ApiMovie apiMovieResponse = webClient.get()
                .uri("?apikey=" + API_KEY + "&i=" + id)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .toEntity(ApiMovie.class)
                .block()
                .getBody();

        if (apiMovieResponse == null) {
            throw new OmdbApiException("Problems while calling Omdb API. Nothing could be found");
        }

        return mapToMovie(apiMovieResponse);
    }

    public List<Movie> getMoviesByTitle(String title) {

        String uri = "?apikey=" + API_KEY + "&s=" + title;

        OmdbResponse apiMoviesResponse = webClient.get()
                .uri(uri)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .toEntity(OmdbResponse.class)
                .block()
                .getBody();

        if (apiMoviesResponse == null || apiMoviesResponse.getSearch() == null) {
            throw new OmdbApiException("Problems while calling Omdb API. Nothing could be found");
        }

        return apiMoviesResponse.getSearch().stream()
                .map(MovieApiService::mapToMovie)
                .toList();
    }

    private static Movie mapToMovie(ApiMovie apiMovieResponse) {
        return Movie.builder()
                .id(apiMovieResponse.getId())
                .title(apiMovieResponse.getTitle())
                .year(apiMovieResponse.getYear())
                .poster(apiMovieResponse.getPoster())
                .build();
    }


}
