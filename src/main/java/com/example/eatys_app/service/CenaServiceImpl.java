package com.example.eatys_app.service;


import com.example.eatys_app.model.Cena;
import com.example.eatys_app.model.Meni;
import com.example.eatys_app.model.Obrok;
import com.example.eatys_app.model.exceptions.InvalidMeniIdException;
import com.example.eatys_app.model.exceptions.InvalidObrokIdException;
import com.example.eatys_app.model.exceptions.InvalidUniqueIdException;
import com.example.eatys_app.repository.CenaRepository;
import com.example.eatys_app.repository.MeniRepository;
import com.example.eatys_app.repository.ObrokRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CenaServiceImpl implements CenaService{

    private final CenaRepository cenaRepository;
    private final ObrokRepository obrokRepository;
    private final MeniRepository meniRepository;

    public CenaServiceImpl(CenaRepository cenaRepository, ObrokRepository obrokRepository, MeniRepository meniRepository) {
        this.cenaRepository = cenaRepository;
        this.obrokRepository = obrokRepository;
        this.meniRepository = meniRepository;
    }


    @Override
    public Cena findbyUniqueId(Integer uid) {
        return this.cenaRepository.findById(uid).orElseThrow(InvalidUniqueIdException::new);
    }

    @Override
    public List<Cena> listAll() {
        return this.cenaRepository.findAll();
    }

    @Override
    public Obrok findById(Integer id) {
        return this.obrokRepository.findById(id).orElseThrow(InvalidObrokIdException::new);
    }

    @Override
    public Cena create(Integer cenaId,Integer obrokId, Integer cenaIznos, Date cenaVaziOd, Date cenaVaziDo) {
        Obrok obrok= this.obrokRepository.findById(obrokId).orElseThrow(InvalidObrokIdException::new);
        Cena cena = new Cena(cenaId,obrok,cenaIznos,cenaVaziOd,cenaVaziDo);
        return this.cenaRepository.save(cena);
    }

    @Override
    public Cena update(Integer id, Integer obrokId, Integer cenaIznos, Date cenaVaziOd, Date cenaVaziDo) {
        Obrok obrok= this.obrokRepository.findById(obrokId).orElseThrow(InvalidObrokIdException::new);
        Cena cena=this.findbyUniqueId(id);
        cena.setObrok(obrok);
        cena.setCenaIznos(cenaIznos);
        cena.setCenaVaziOd(cenaVaziOd);
        cena.setCenaVaziDo(cenaVaziDo);
        return this.cenaRepository.save(cena);
    }

    @Override
    public Cena delete(Integer id) {
        Cena cena=this.findbyUniqueId(id);
        this.cenaRepository.deleteById(id);
        return cena;
    }

    @Override
    public List<Cena> listCeniByObrok( Integer meniId) {
        Meni meni=this.meniRepository.findById(meniId).orElseThrow(InvalidMeniIdException::new);
        List<Obrok>obroci=this.obrokRepository.findAllByMeni(meni);
        return this.cenaRepository.findAllByObrokIn(obroci);
    }
}
