package com.example.eatys_app.service;


import com.example.eatys_app.model.Tip;

import java.util.List;

public interface TipService {

    Tip findById(Integer id);

    List<Tip> listAll();

    Tip create(String ime);

}
