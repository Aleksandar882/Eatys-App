package com.example.eatys_app.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "naracka", schema = "project")
public class Naracka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "naracka_id")
    private Integer id;

    @Column(name = "naracana_na")
    private Timestamp naracana;

    @Column(name = "naracka_status")
    private String status;

    @Column(name = "naracka_cena_vkupna")
    private Integer cena;

    @ManyToOne
    @JoinColumn(name = "user_id_kupuvac")
    private Kupuvac kupuvac;

    @ManyToOne
    @JoinColumn(name = "user_id_dostavuvac")
    private Dostavuvac dostavuvac;


    @OneToMany(mappedBy = "naracka")
    private Set<SeSostoiOd> narackaSeSostoiOd = new HashSet<SeSostoiOd>();


    public Naracka() {
    }

    public Naracka(Timestamp naracana, String status, Integer cena, Kupuvac kupuvac, Dostavuvac dostavuvac) {
        this.naracana = naracana;
        this.status = status;
        this.cena = cena;
        this.kupuvac = kupuvac;
        this.dostavuvac = dostavuvac;

    }

    public Naracka(Kupuvac kupuvac) {
        this.kupuvac=kupuvac;
    }

    public Naracka(Integer id, Timestamp naracana, String status, Integer cena, Kupuvac kupuvac, Dostavuvac dostavuvac) {
        this.id = id;
        this.naracana = naracana;
        this.status = status;
        this.cena = cena;
        this.kupuvac = kupuvac;
        this.dostavuvac = dostavuvac;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getNaracana() {
        return naracana;
    }

    public void setNaracana(Timestamp naracana) {
        this.naracana = naracana;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    public Kupuvac getKupuvac() {
        return kupuvac;
    }

    public void setKupuvac(Kupuvac kupuvac) {
        this.kupuvac = kupuvac;
    }

    public Dostavuvac getDostavuvac() {
        return dostavuvac;
    }

    public void setDostavuvac(Dostavuvac dostavuvac) {
        this.dostavuvac = dostavuvac;
    }

    public Set<SeSostoiOd> getNarackaSeSostoiOd() {
        return narackaSeSostoiOd;
    }

    public void setNarackaSeSostoiOd(Set<SeSostoiOd> narackaSeSostoiOd) {
        this.narackaSeSostoiOd = narackaSeSostoiOd;
    }
}
