package com.example.eatys_app.service;

import com.example.eatys_app.model.Tip;
import com.example.eatys_app.model.exceptions.InvalidTipIdException;
import com.example.eatys_app.repository.TipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipServiceImpl implements TipService{

    private final TipRepository tipRepository;

    public TipServiceImpl(TipRepository tipRepository) {
        this.tipRepository = tipRepository;
    }


    @Override
    public Tip findById(Integer id) {
        return this.tipRepository.findById(id).orElseThrow(InvalidTipIdException::new);
    }

    @Override
    public List<Tip> listAll() {
        return this.tipRepository.findAll();
    }

    @Override
    public Tip create(String ime) {
        Tip tip = new Tip(ime);
        return this.tipRepository.save(tip);
    }
}
