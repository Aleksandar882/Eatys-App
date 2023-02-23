package com.example.eatys_app.model.exceptions;

public class KupuvacNotFoundException extends RuntimeException{

    public KupuvacNotFoundException(String username) {
        super(String.format("User with username: %s was not found", username));
    }

}
