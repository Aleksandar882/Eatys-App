package com.example.eatys_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name="dostavuvac", schema = "project")
public class Dostavuvac extends Korisnik{

    @Column(name="dostavuvac_vraboten_od")
    private Date vraboten_od;

    public Date getVraboten_od() {
        return vraboten_od;
    }

    public void setVraboten_od(Date vraboten_od) {
        this.vraboten_od = vraboten_od;
    }
}
