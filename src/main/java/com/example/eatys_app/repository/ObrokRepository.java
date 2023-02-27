package com.example.eatys_app.repository;

import com.example.eatys_app.model.Kupuvac;
import com.example.eatys_app.model.Meni;
import com.example.eatys_app.model.Obrok;
import com.example.eatys_app.model.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObrokRepository extends JpaRepository<Obrok,Integer> {

    List<Obrok> findAllByMeni(Meni meni);

}
