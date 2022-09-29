package com.example.backend.model;

import lombok.Builder;
import lombok.Data;

@Data
public class MovieDetail extends Movie {

    private String plot;
    private String rating;
    private String runtime;

    @Builder(builderMethodName = "movieDetailBuilder")
    public MovieDetail(String id, String title, String year, String poster, String plot, String rating, String runtime) {
        super(id, title, year, poster);
        this.plot = plot;
        this.rating = rating;
        this.runtime = runtime;
    }

    public MovieDetail() {
        super();
    }
}
