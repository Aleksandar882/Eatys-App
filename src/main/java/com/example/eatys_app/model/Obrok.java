package com.example.eatys_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "obrok", schema = "project")
public class Obrok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "obrok_id", nullable = false)
    private Integer Id;

    @Column(name = "obrok_opis", nullable = false)
    private String opis;

    @Column(name = "obrok_ime", nullable = false)
    private String ime;

    @ManyToOne
    @JoinColumn(name = "meni_id", nullable = false)
    private Meni meni;

    public Obrok() {
    }

    public Obrok(String ime,String opis, Meni meni) {
        this.ime = ime;
        this.opis = opis;
        this.meni = meni;
    }



    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Meni getMeni() {
        return meni;
    }

    public void setMeni(Meni meni) {
        this.meni = meni;
    }
}