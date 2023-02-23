package com.example.eatys_app.service;

import com.example.eatys_app.model.Kupuvac;
import com.example.eatys_app.model.Naracka;
import com.example.eatys_app.model.Obrok;
import com.example.eatys_app.model.SeSostoiOd;
import com.example.eatys_app.model.exceptions.InvalidObrokIdException;
import com.example.eatys_app.model.exceptions.KupuvacNotFoundException;
import com.example.eatys_app.model.exceptions.NarackaNotFoundException;
import com.example.eatys_app.model.exceptions.ObrokNotFound;
import com.example.eatys_app.repository.*;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class NarackaServiceImpl implements NarackaService{

    private final KupuvacRepository kupuvacRepository;
    private final ObrokRepository obrokRepository;
    private final NarackaRepository narackaRepository;
    private final CenaRepository cenaRepository;
    private final SeSostoiOdRepository seSostoiOdRepository;

    public NarackaServiceImpl(KupuvacRepository kupuvacRepository, ObrokRepository obrokRepository, NarackaRepository narackaRepository, CenaRepository cenaRepository, SeSostoiOdRepository seSostoiOdRepository) {
        this.kupuvacRepository = kupuvacRepository;
        this.obrokRepository = obrokRepository;
        this.narackaRepository = narackaRepository;
        this.cenaRepository = cenaRepository;
        this.seSostoiOdRepository = seSostoiOdRepository;
    }

    @Override
    public Set<SeSostoiOd> listAllObrociInShoppingCart(Integer cartId) {
        if(!this.narackaRepository.findById(cartId).isPresent())
            throw new NarackaNotFoundException(cartId);
        Set<SeSostoiOd> se_sostoi_od=this.narackaRepository.findById(cartId).get().getNarackaSeSostoiOd();
//        se_sostoi_od.forEach(SeSostoiOd::getCena);
        return this.narackaRepository.findById(cartId).get().getNarackaSeSostoiOd();
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

    @Override
    public SeSostoiOd addObrokToShoppingCart(String username, Integer obrokId) {

        Naracka shoppingCart = this.getActiveShoppingCart(username);
        Obrok obrok = this.obrokRepository.findById(obrokId).orElseThrow(ObrokNotFound::new);
        Integer kolicina=1;
        Integer cena=this.cenaRepository.findByObrok(obrok).orElseThrow(InvalidObrokIdException::new).getCenaIznos();
        SeSostoiOd seSostoiOd = new SeSostoiOd(shoppingCart,obrok,kolicina,cena);

//        shoppingCart.getNarackaSeSostoiOd().add(seSostoiOd);
        return this.seSostoiOdRepository.save(seSostoiOd);

    }

}
