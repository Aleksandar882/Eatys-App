package com.example.eatys_app.repository;

import com.example.eatys_app.model.Cena;
import com.example.eatys_app.model.CenaId;
import com.example.eatys_app.model.Meni;
import com.example.eatys_app.model.Obrok;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CenaRepository extends JpaRepository<Cena, Integer> {

    void deleteById(Integer id);

    Optional<Cena> findById(Integer uid);

    Optional<Cena> findByObrok(Obrok obrok);

    List<Cena> findAllByObrokIn(List<Obrok> obrok);
}
