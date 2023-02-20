package com.example.eatys_app.service;


import com.example.eatys_app.model.Korisnik;
import com.example.eatys_app.model.exceptions.InvalidArgumentsException;
import com.example.eatys_app.model.exceptions.InvalidUserCredentialsException;
import com.example.eatys_app.repository.KorisnikRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    private final KorisnikRepository korisnikRepository;

    public AuthServiceImpl(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public Korisnik login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return korisnikRepository.findByImeAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }
}
