package com.example.eatys_app.repository;

import com.example.eatys_app.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeSostoiOdRepository extends JpaRepository<SeSostoiOd, SeSostoiOdId>{

    Optional<SeSostoiOd> findByNaracka(Naracka naracka);

    Optional<SeSostoiOd> findByNarackaAndObrok(Naracka naracka, Obrok obrok);

}
