package com.example.eatys_app.service;

import com.example.eatys_app.model.Naracka;
import com.example.eatys_app.model.Obrok;
import com.example.eatys_app.model.SeSostoiOd;

public interface SeSostoiOdService {

    SeSostoiOd create(String kupuvacName, Integer obrokId, Integer kolicina);

    public Naracka getActiveShoppingCart(String username);

    SeSostoiOd delete(String kupuvacName, Integer obrokId);

    public void payment(String kupuvacName);

}
