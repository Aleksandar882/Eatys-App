package com.example.eatys_app.model.exceptions;

public class KorisnikNotFoundException extends RuntimeException {

    public KorisnikNotFoundException(String username) {
        super(String.format("User with username: %s was not found", username));
    }
}
