package com.example.eatys_app.service;

import com.example.eatys_app.model.Meni;
import com.example.eatys_app.model.Obrok;

import java.util.List;

public interface ObrokService {

    List<Obrok> listAll();

    Obrok findById(Integer id);

    Obrok create(String ime,String opis, Integer meniId);

    Obrok update(Integer id, String ime,String opis, Integer meniId);

    Obrok delete(Integer id);

}
