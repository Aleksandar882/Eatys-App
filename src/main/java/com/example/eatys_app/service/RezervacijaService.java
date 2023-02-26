package com.example.eatys_app.service;

import com.example.eatys_app.model.Rezervacija;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RezervacijaService {

    List<Rezervacija> getActiveRezervacii(String username);

    Rezervacija findById(Integer id);

    Rezervacija create(String kupuvacIme, Date vreme, Integer lugje, String opis, Integer restoranId);

    Rezervacija update(Integer id, String kupuvacIme,Date vreme, Integer lugje, String opis, Integer restoranId);

    Rezervacija delete(Integer id);
}
