package com.example.eatys_app.repository;

import com.example.eatys_app.model.Korisnik;
import com.example.eatys_app.model.Kupuvac;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KupuvacRepository extends JpaRepository<Kupuvac,Integer> {

    Optional<Kupuvac> findByIme(String ime);

}
