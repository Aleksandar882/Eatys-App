package com.example.eatys_app.service;

import com.example.eatys_app.model.Menadzer;

import java.util.Date;
import java.util.List;

public interface MenadzerService {

    Menadzer findById(Integer id);

    List<Menadzer> listAll();

    Menadzer create(Date vraboten_od);
}
