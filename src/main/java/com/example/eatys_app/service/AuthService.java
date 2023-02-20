package com.example.eatys_app.service;

import com.example.eatys_app.model.Korisnik;

public interface AuthService {

    Korisnik login(String username, String password);

}
