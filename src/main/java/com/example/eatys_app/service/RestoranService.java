package com.example.eatys_app.service;


import com.example.eatys_app.model.Menadzer;
import com.example.eatys_app.model.Restoran;

import java.util.List;

public interface RestoranService {

    List<Restoran> listAll();

    Restoran findById(Integer id);

    Restoran create(String ime, Integer rejting, String adresa, Integer menadzerId);

    Restoran update( Integer id, String ime, Integer rejting, String adresa,  Integer menadzerId);

    Restoran delete(Integer id);
}
