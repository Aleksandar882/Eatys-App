package com.example.eatys_app.service;

import com.example.eatys_app.model.Naracka;
import com.example.eatys_app.model.Obrok;
import com.example.eatys_app.model.SeSostoiOd;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public interface NarackaService {

//    List<Naracka> listAll();
//
//    Naracka findById(Integer id);
//
//    Naracka create(Timestamp naracana, Integer status, Integer cena, Integer kupuvacId, Integer dostavuvacId);
//
//    Naracka update(Integer id, Timestamp naracana, Integer status, Integer cena, Integer kupuvacId, Integer dostavuvacId);
//
//    Naracka delete(Integer id);

    Set<SeSostoiOd> listAllObrociInShoppingCart(Integer cartId);

    Naracka getActiveShoppingCart(String username);

     SeSostoiOd addObrokToShoppingCart(String username, Integer obrokId);

    public int Total(Integer cartId);


}
