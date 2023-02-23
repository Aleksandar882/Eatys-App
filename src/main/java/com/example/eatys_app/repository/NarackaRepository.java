package com.example.eatys_app.repository;

import com.example.eatys_app.model.Kupuvac;
import com.example.eatys_app.model.Naracka;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NarackaRepository extends JpaRepository<Naracka,Integer> {

    Optional<Naracka> findByKupuvac(Kupuvac kupuvac);

}
