package com.example.eatys_app.service;

import com.example.eatys_app.model.Meni;
import com.example.eatys_app.model.Restoran;
import com.example.eatys_app.model.Tip;
import com.example.eatys_app.model.exceptions.InvalidMeniIdException;
import com.example.eatys_app.model.exceptions.InvalidRestoranIdException;
import com.example.eatys_app.model.exceptions.InvalidTipIdException;
import com.example.eatys_app.repository.MeniRepository;
import com.example.eatys_app.repository.RestoranRepository;
import com.example.eatys_app.repository.TipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeniServiceImpl implements MeniService{

    private final MeniRepository meniRepository;
    private final RestoranRepository restoranRepository;
    private final TipRepository tipRepository;

    public MeniServiceImpl(MeniRepository meniRepository, RestoranRepository restoranRepository, TipRepository tipRepository) {
        this.meniRepository = meniRepository;
        this.restoranRepository = restoranRepository;
        this.tipRepository = tipRepository;
    }

    @Override
    public List<Meni> listAll() {
        return this.meniRepository.findAll();
    }

    @Override
    public Meni findById(Integer id) {
        return this.meniRepository.findById(id).orElseThrow(InvalidMeniIdException::new);
    }

    @Override
    public Meni create(Integer tipId, Integer restoranId) {
        Restoran restoran =this.restoranRepository.findById(restoranId).orElseThrow(InvalidRestoranIdException::new);
        Tip tip = this.tipRepository.findById(tipId).orElseThrow(InvalidTipIdException::new);
        Meni meni = new Meni(restoran,tip);
        return this.meniRepository.save(meni);
    }

    @Override
    public Meni update(Integer id, Integer tipId, Integer restoranId) {
        Restoran restoran =this.restoranRepository.findById(restoranId).orElseThrow(InvalidRestoranIdException::new);
        Tip tip = this.tipRepository.findById(tipId).orElseThrow(InvalidTipIdException::new);
        Meni meni=this.findById(id);
        meni.setTip(tip);
        meni.setRestoran(restoran);
        return this.meniRepository.save(meni);
    }

    @Override
    public Meni delete(Integer id) {
        Meni meni=this.findById(id);
        this.meniRepository.delete(meni);
        return meni;
    }
}
