package com.example.eatys_app.service;

import com.example.eatys_app.model.Naracka;
import com.example.eatys_app.model.Obrok;
import com.example.eatys_app.model.SeSostoiOd;

public interface SeSostoiOdService {

    SeSostoiOd create(String kupuvacName, Integer obrokId);

    public Naracka getActiveShoppingCart(String username);

}
