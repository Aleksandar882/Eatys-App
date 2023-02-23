package com.example.eatys_app.model.exceptions;

public class NarackaNotFoundException extends RuntimeException{

    public NarackaNotFoundException(Integer id) {
        super(String.format("Shopping cart with id: %d was not found", id));
    }

}
