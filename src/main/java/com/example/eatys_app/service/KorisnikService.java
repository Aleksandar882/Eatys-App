package com.example.eatys_app.service;

import com.example.eatys_app.model.Korisnik;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface KorisnikService extends UserDetailsService {


    Korisnik register(String ime, String prezime, String password, String repeatPassword);

    Korisnik FindByName(String ime);
}
