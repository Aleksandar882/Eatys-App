package com.example.eatys_app.service;

import com.example.eatys_app.model.Korisnik;
import com.example.eatys_app.model.exceptions.InvalidUsernameException;
import com.example.eatys_app.model.exceptions.InvalidUsernameOrPasswordException;
import com.example.eatys_app.model.exceptions.PasswordsDoNotMatchException;
import com.example.eatys_app.model.exceptions.UsernameAlreadyExistsException;
import com.example.eatys_app.repository.KorisnikRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class KorisnikServiceImpl implements KorisnikService{

    private final KorisnikRepository korisnikRepository;
    private final PasswordEncoder passwordEncoder;

    public KorisnikServiceImpl(KorisnikRepository korisnikRepository, PasswordEncoder passwordEncoder) {
        this.korisnikRepository = korisnikRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Korisnik register(String ime, String prezime, String password, String repeatPassword) {
        if (ime==null || ime.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.korisnikRepository.findByIme(ime).isPresent())
            throw new UsernameAlreadyExistsException(ime);
        Korisnik user = new Korisnik(ime,prezime,passwordEncoder.encode(password));
        return korisnikRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String ime) throws UsernameNotFoundException {

        Korisnik user=  this.korisnikRepository.findByIme(ime).orElseThrow(InvalidUsernameException::new);
        UserDetails userDetails= new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(),user.getAuthorities());
        return userDetails;
    }
}
