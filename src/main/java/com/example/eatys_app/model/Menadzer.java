package com.example.eatys_app.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="menadzer", schema = "project")
public class Menadzer extends Korisnik {

    @Column(name="menadzer_vraboten_od")
    private Date vraboten_od;

    public Menadzer(Date vraboten_od) {
        this.vraboten_od = vraboten_od;
    }

    public Menadzer() {

    }

    public Date getVraboten_od() {
        return vraboten_od;
    }

    public void setVraboten_od(Date vraboten_od) {
        this.vraboten_od = vraboten_od;
    }

}
