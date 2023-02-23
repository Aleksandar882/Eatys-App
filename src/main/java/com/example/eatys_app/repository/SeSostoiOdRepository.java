package com.example.eatys_app.repository;

import com.example.eatys_app.model.Kupuvac;
import com.example.eatys_app.model.Naracka;
import com.example.eatys_app.model.SeSostoiOd;
import com.example.eatys_app.model.SeSostoiOdId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeSostoiOdRepository extends JpaRepository<SeSostoiOd, SeSostoiOdId>{

    Optional<SeSostoiOd> findByNaracka(Naracka naracka);

}
