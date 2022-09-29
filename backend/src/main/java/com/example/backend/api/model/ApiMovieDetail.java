package com.example.backend.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiMovieDetail {

    @JsonProperty("imdbID")
    private String id;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("Poster")
    private String poster;
    @JsonProperty("Plot")
    private String plot;
    @JsonProperty("imdbRating")
    private String rating;
    @JsonProperty("Runtime")
    private String runtime;
}
