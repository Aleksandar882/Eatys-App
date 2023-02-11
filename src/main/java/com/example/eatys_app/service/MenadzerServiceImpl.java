package com.example.eatys_app.service;

import com.example.eatys_app.model.Menadzer;
import com.example.eatys_app.model.exceptions.InvalidMenadzerIdException;
import com.example.eatys_app.repository.MenadzerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MenadzerServiceImpl implements MenadzerService{

    private final MenadzerRepository menadzerRepository;

    public MenadzerServiceImpl(MenadzerRepository menadzerRepository) {
        this.menadzerRepository = menadzerRepository;
    }


    @Override
    public Menadzer findById(Integer id) {
        return this.menadzerRepository.findById(id).orElseThrow(InvalidMenadzerIdException::new);
    }

    @Override
    public List<Menadzer> listAll() {
        return this.menadzerRepository.findAll();
    }

    @Override
    public Menadzer create(Date vraboten_od) {
        Menadzer menadzer = new Menadzer(vraboten_od);
        return this.menadzerRepository.save(menadzer);
    }
}
