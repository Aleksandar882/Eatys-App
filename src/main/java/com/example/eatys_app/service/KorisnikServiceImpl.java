package com.example.eatys_app.service;

import com.example.eatys_app.model.Korisnik;
import com.example.eatys_app.model.Kupuvac;
import com.example.eatys_app.model.exceptions.InvalidUsernameException;
import com.example.eatys_app.model.exceptions.InvalidUsernameOrPasswordException;
import com.example.eatys_app.model.exceptions.PasswordsDoNotMatchException;
import com.example.eatys_app.model.exceptions.UsernameAlreadyExistsException;
import com.example.eatys_app.repository.KorisnikRepository;
import com.example.eatys_app.repository.KupuvacRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class KorisnikServiceImpl implements KorisnikService{

    private final KorisnikRepository korisnikRepository;
    private final PasswordEncoder passwordEncoder;
    private final KupuvacRepository kupuvacRepository;

    public KorisnikServiceImpl(KorisnikRepository korisnikRepository, PasswordEncoder passwordEncoder, KupuvacRepository kupuvacRepository) {
        this.korisnikRepository = korisnikRepository;
        this.passwordEncoder = passwordEncoder;
        this.kupuvacRepository = kupuvacRepository;
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
        Kupuvac kupuvac= new Kupuvac();
        kupuvac.setIme(ime);
        kupuvac.setPrezime(prezime);
        kupuvac.setPassword(passwordEncoder.encode(password));
        return kupuvacRepository.save(kupuvac);
    }

    @Override
    public Korisnik FindByName(String ime) {
        Korisnik user=  this.korisnikRepository.findByIme(ime).orElseThrow(InvalidUsernameException::new);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String ime) throws UsernameNotFoundException {

        Korisnik user=  this.korisnikRepository.findByIme(ime).orElseThrow(InvalidUsernameException::new);
        UserDetails userDetails= new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(),user.getAuthorities());
        return userDetails;
    }

}
