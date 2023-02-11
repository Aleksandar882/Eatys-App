package com.example.eatys_app.service;

import com.example.eatys_app.model.Menadzer;
import com.example.eatys_app.model.Restoran;
import com.example.eatys_app.model.exceptions.InvalidMenadzerIdException;
import com.example.eatys_app.model.exceptions.InvalidRestoranIdException;
import com.example.eatys_app.repository.MenadzerRepository;
import com.example.eatys_app.repository.RestoranRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestoranServiceImpl implements RestoranService{

    private final RestoranRepository restoranRepository;
    private final MenadzerRepository menadzerRepository;

    public RestoranServiceImpl(RestoranRepository restoranRepository, MenadzerRepository menadzerRepository) {
        this.restoranRepository = restoranRepository;
        this.menadzerRepository = menadzerRepository;
    }



    @Override
    public List<Restoran> listAll() {
        return this.restoranRepository.findAll();
    }

    @Override
    public Restoran findById(Integer id) {
        return this.restoranRepository.findById(id).orElseThrow(InvalidRestoranIdException::new);
    }

    @Override
    public Restoran create(String ime, Integer rejting, String adresa, Integer menadzerId) {
        Menadzer menadzer = this.menadzerRepository.findById(menadzerId).orElseThrow(InvalidMenadzerIdException::new);
        Restoran restoran= new Restoran(ime,rejting,adresa,menadzer);
        return this.restoranRepository.save(restoran);
    }

    @Override
    public Restoran update(Integer id, String ime, Integer rejting, String adresa,  Integer menadzerId) {
        Menadzer menadzer = this.menadzerRepository.findById(menadzerId).orElseThrow(InvalidMenadzerIdException::new);
        Restoran restoran=this.findById(id);
        restoran.setIme(ime);
        restoran.setRejting(rejting);
        restoran.setAdresa(adresa);
        restoran.setMenadzer(menadzer);
        return this.restoranRepository.save(restoran);
    }

    @Override
    public Restoran delete(Integer id) {
        Restoran restoran=this.findById(id);
        this.restoranRepository.delete(restoran);
        return restoran;
    }
}
