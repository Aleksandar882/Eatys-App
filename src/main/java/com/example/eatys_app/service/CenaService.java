package com.example.eatys_app.service;

import com.example.eatys_app.model.Cena;
import com.example.eatys_app.model.CenaId;
import com.example.eatys_app.model.Obrok;

import java.util.Date;
import java.util.List;

public interface CenaService {

    Cena findbyUniqueId(Integer uid);

    List<Cena> listAll();

    Obrok findById(Integer id);

    Cena create(Integer cenaId,Integer obrokId, Integer cenaIznos, Date cenaVaziOd, Date cenaVaziDo);

    Cena update(Integer id, Integer obrokId, Integer cenaIznos, Date cenaVaziOd, Date cenaVaziDo);

    Cena delete(Integer id);

}
