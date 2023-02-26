package com.example.eatys_app.service;

import com.example.eatys_app.model.Kupuvac;
import com.example.eatys_app.model.Restoran;
import com.example.eatys_app.model.Rezervacija;
import com.example.eatys_app.model.exceptions.InvalidRestoranIdException;
import com.example.eatys_app.model.exceptions.InvalidRezervacijaIdException;
import com.example.eatys_app.model.exceptions.KupuvacNotFoundException;
import com.example.eatys_app.model.exceptions.KupuvacNotFoundException2;
import com.example.eatys_app.repository.KupuvacRepository;
import com.example.eatys_app.repository.RestoranRepository;
import com.example.eatys_app.repository.RezervacijaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RezervacijaServiceImpl implements RezervacijaService{

    private final KupuvacRepository kupuvacRepository;
    private final RezervacijaRepository rezervacijaRepository;
    private final RestoranRepository restoranRepository;

    public RezervacijaServiceImpl(KupuvacRepository kupuvacRepository, RezervacijaRepository rezervacijaRepository, RestoranRepository restoranRepository) {
        this.kupuvacRepository = kupuvacRepository;
        this.rezervacijaRepository = rezervacijaRepository;
        this.restoranRepository = restoranRepository;
    }

    @Override
    public List<Rezervacija> getActiveRezervacii(String username) {
        Kupuvac kupuvac = this.kupuvacRepository.findByIme(username)
                .orElseThrow(() -> new KupuvacNotFoundException(username));
        return this.rezervacijaRepository.findAllByKupuvac(kupuvac);
    }

    @Override
    public Rezervacija findById(Integer id) {
        return this.rezervacijaRepository.findById(id).orElseThrow(InvalidRezervacijaIdException::new);
    }

    @Override
    public Rezervacija create(String kupuvacIme, Date vreme, Integer lugje, String opis, Integer restoranId) {
        Restoran restoran=this.restoranRepository.findById(restoranId).orElseThrow(InvalidRestoranIdException::new);
        String status="R";
        Kupuvac kupuvac=this.kupuvacRepository.findByIme(kupuvacIme).orElseThrow(KupuvacNotFoundException2::new);
        Rezervacija rezervacija= new Rezervacija(vreme,lugje,status,opis,restoran,kupuvac);
        return this.rezervacijaRepository.save(rezervacija);
    }

    @Override
    public Rezervacija update(Integer id, String kupuvacIme, Date vreme, Integer lugje, String opis, Integer restoranId) {
        Rezervacija rezervacija=this.rezervacijaRepository.findById(id).orElseThrow(InvalidRezervacijaIdException::new);
        Restoran restoran=this.restoranRepository.findById(restoranId).orElseThrow(InvalidRestoranIdException::new);
        String status="R";
        Kupuvac kupuvac=this.kupuvacRepository.findByIme(kupuvacIme).orElseThrow(KupuvacNotFoundException2::new);
        rezervacija.setVreme(vreme);
        rezervacija.setLugje(lugje);
        rezervacija.setStatus(status);
        rezervacija.setOpis(opis);
        rezervacija.setRestoran(restoran);
        rezervacija.setKupuvac(kupuvac);
        return this.rezervacijaRepository.save(rezervacija);
    }

    @Override
    public Rezervacija delete(Integer id) {
        Rezervacija rezervacija=this.findById(id);
        this.rezervacijaRepository.delete(rezervacija);
        return rezervacija;
    }
}
