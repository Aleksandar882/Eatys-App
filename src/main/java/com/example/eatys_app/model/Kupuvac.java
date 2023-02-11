package com.example.eatys_app.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="kupuvac", schema = "project")
public class Kupuvac extends Korisnik{

    @Column(name = "kupuvac_tel_broj")
    private String tel_broj;

    @OneToMany(mappedBy = "kupuvac")
    private Set<Rezervacija> rezervacii = new LinkedHashSet<>();

    public String getTel_broj() {
        return tel_broj;
    }

    public void setTel_broj(String tel_broj) {
        this.tel_broj = tel_broj;
    }

    public Set<Rezervacija> getRezervacii() {
        return rezervacii;
    }

    public void setRezervacii(Set<Rezervacija> rezervacii) {
        this.rezervacii = rezervacii;
    }
}
