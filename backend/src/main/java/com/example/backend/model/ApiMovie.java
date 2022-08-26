package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiMovie {

    @JsonProperty("Title")
    String title;
    @JsonProperty("Year")
    String year;
    @JsonProperty("Released")
    String released;
    @JsonProperty("Genre")
    String genre;
    @JsonProperty("Plot")
    String plot;
    @JsonProperty("Poster")
    String poster;
}
