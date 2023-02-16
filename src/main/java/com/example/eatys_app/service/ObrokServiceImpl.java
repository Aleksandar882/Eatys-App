package com.example.eatys_app.service;

import com.example.eatys_app.model.Meni;
import com.example.eatys_app.model.Obrok;
import com.example.eatys_app.model.exceptions.InvalidMeniIdException;
import com.example.eatys_app.model.exceptions.InvalidObrokIdException;
import com.example.eatys_app.repository.MeniRepository;
import com.example.eatys_app.repository.ObrokRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObrokServiceImpl implements ObrokService{

    private final ObrokRepository obrokRepository;
    private final MeniRepository meniRepository;

    public ObrokServiceImpl(ObrokRepository obrokRepository, MeniRepository meniRepository) {
        this.obrokRepository = obrokRepository;
        this.meniRepository = meniRepository;
    }

    @Override
    public List<Obrok> listAll() {
        return this.obrokRepository.findAll();
    }

    @Override
    public Obrok findById(Integer id) {
        return this.obrokRepository.findById(id).orElseThrow(InvalidObrokIdException::new);
    }

    @Override
    public Obrok create(String ime, String opis, Integer meniId) {
        Meni meni=this.meniRepository.findById(meniId).orElseThrow(InvalidMeniIdException::new);
        Obrok obrok= new Obrok(ime,opis,meni);
        return this.obrokRepository.save(obrok);
    }

    @Override
    public Obrok update(Integer id, String ime, String opis, Integer meniId) {
        Meni meni=this.meniRepository.findById(meniId).orElseThrow(InvalidMeniIdException::new);
        Obrok obrok=this.findById(id);
        obrok.setIme(ime);
        obrok.setOpis(opis);
        obrok.setMeni(meni);
        return this.obrokRepository.save(obrok);
    }

    @Override
    public Obrok delete(Integer id) {
        Obrok obrok=this.findById(id);
        this.obrokRepository.delete(obrok);
        return obrok;
    }
}
