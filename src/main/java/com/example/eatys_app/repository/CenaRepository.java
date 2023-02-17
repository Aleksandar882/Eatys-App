package com.example.eatys_app.repository;

import com.example.eatys_app.model.Cena;
import com.example.eatys_app.model.CenaId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CenaRepository extends JpaRepository<Cena, Integer> {

    void deleteById(Integer id);

    Optional<Cena> findById(Integer uid);
}
