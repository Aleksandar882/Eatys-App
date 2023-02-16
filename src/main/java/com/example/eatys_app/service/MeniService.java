package com.example.eatys_app.service;

import com.example.eatys_app.model.Meni;

import java.util.List;

public interface MeniService {

    List<Meni> listAll();

    Meni findById(Integer id);

    Meni create(Integer tipId, Integer restoranId);

    Meni update(Integer id, Integer tipId, Integer restoranId);

    Meni delete(Integer id);
}
