package com.example.backend.api;

public class OmdbApiException extends RuntimeException {
    public OmdbApiException(String message) {
        super(message);
    }
}
