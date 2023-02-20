package com.example.eatys_app.model.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{

    public UsernameAlreadyExistsException(String username) {
        super(String.format("User with username: %s already exists", username));
    }

}