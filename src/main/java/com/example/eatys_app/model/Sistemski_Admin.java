package com.example.eatys_app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="sistemski_admin", schema = "project")
public class Sistemski_Admin extends Korisnik {

    public Sistemski_Admin() {
    }

    public Sistemski_Admin(String ime, String prezime, String password) {
        super(ime, prezime, password);
    }
}
