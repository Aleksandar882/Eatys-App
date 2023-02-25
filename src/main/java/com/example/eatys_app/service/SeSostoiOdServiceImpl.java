package com.example.eatys_app.service;


import com.example.eatys_app.model.Kupuvac;
import com.example.eatys_app.model.Naracka;
import com.example.eatys_app.model.Obrok;
import com.example.eatys_app.model.SeSostoiOd;
import com.example.eatys_app.model.exceptions.*;
import com.example.eatys_app.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class SeSostoiOdServiceImpl implements SeSostoiOdService {

    private final SeSostoiOdRepository seSostoiOdRepository;
    private final NarackaRepository narackaRepository;
    private final ObrokRepository obrokRepository;
    private final KupuvacRepository kupuvacRepository;
    private final CenaRepository cenaRepository;

    public SeSostoiOdServiceImpl(SeSostoiOdRepository seSostoiOdRepository, NarackaRepository narackaRepository, ObrokRepository obrokRepository, KupuvacRepository kupuvacRepository, CenaRepository cenaRepository) {
        this.seSostoiOdRepository = seSostoiOdRepository;
        this.narackaRepository = narackaRepository;
        this.obrokRepository = obrokRepository;
        this.kupuvacRepository = kupuvacRepository;
        this.cenaRepository = cenaRepository;
    }


    @Override
    public SeSostoiOd create(String kupuvacName, Integer obrokId, Integer kolicina) {
        Kupuvac kupuvac=this.kupuvacRepository.findByIme(kupuvacName).orElseThrow(KupuvacNotFoundException2::new);
        Naracka naracka=this.narackaRepository.findByKupuvac(kupuvac).orElseThrow(NarackaNotFoundException2::new);
        Obrok obrok=this.obrokRepository.findById(obrokId).orElseThrow(InvalidObrokIdException::new);
        Integer cena=this.cenaRepository.findByObrok(obrok).orElseThrow(InvalidObrokIdException::new).getCenaIznos()*kolicina;
        SeSostoiOd seSostoiOd = new SeSostoiOd(naracka,obrok,kolicina,cena);
        return this.seSostoiOdRepository.save(seSostoiOd);
    }

    @Override
    public SeSostoiOd delete(String kupuvacName, Integer obrokId) {
        Kupuvac kupuvac=this.kupuvacRepository.findByIme(kupuvacName).orElseThrow(KupuvacNotFoundException2::new);
        Naracka naracka=this.narackaRepository.findByKupuvac(kupuvac).orElseThrow(NarackaNotFoundException2::new);
        Obrok obrok=this.obrokRepository.findById(obrokId).orElseThrow(InvalidObrokIdException::new);
        SeSostoiOd seSostoiOd=this.seSostoiOdRepository.findByNarackaAndObrok(naracka,obrok).orElseThrow(InvalidNarackaAndObrokException::new);
        this.seSostoiOdRepository.delete(seSostoiOd);
        return seSostoiOd;
    }


    @Override
    public void payment(String kupuvacName) {
        Kupuvac kupuvac=this.kupuvacRepository.findByIme(kupuvacName).orElseThrow(KupuvacNotFoundException2::new);
        Naracka naracka=this.narackaRepository.findByKupuvac(kupuvac).orElseThrow(NarackaNotFoundException2::new);
        this.narackaRepository.delete(naracka);
    }


    @Override
    public Naracka getActiveShoppingCart(String username) {

        Kupuvac kupuvac = this.kupuvacRepository.findByIme(username)
                .orElseThrow(() -> new KupuvacNotFoundException(username));

        return this.narackaRepository
                .findByKupuvac(kupuvac)
                .orElseGet(() -> {
                    Naracka cart = new Naracka(kupuvac);
                    return this.narackaRepository.save(cart);
                });
    }
}