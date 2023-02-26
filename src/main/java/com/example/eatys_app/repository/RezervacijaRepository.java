package com.example.eatys_app.repository;

import com.example.eatys_app.model.Kupuvac;
import com.example.eatys_app.model.Naracka;
import com.example.eatys_app.model.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RezervacijaRepository extends JpaRepository<Rezervacija, Integer> {

    List<Rezervacija> findAllByKupuvac(Kupuvac kupuvac);

}
