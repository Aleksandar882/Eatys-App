package com.example.eatys_app.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "rezervacija", schema = "project")
public class Rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rezervacija_id", nullable = false)
    private Integer id;

    @Column(name = "rezervacija_vreme", nullable = false)
    private Timestamp vreme;

    @Column(name = "br_lugje", nullable = false)
    private Integer lugje;

    @Column(name = "rezervacija_status", nullable = false, length = 50)
    private String status;

    @Column(name = "rezervacija_opis", nullable = false, length = 10000)
    private String opis;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Kupuvac kupuvac;

    public Rezervacija() {
    }

    public Rezervacija(Timestamp vreme, Integer lugje, String status, String opis, Restoran restoran, Kupuvac kupuvac) {
        this.vreme = vreme;
        this.lugje = lugje;
        this.status = status;
        this.opis = opis;
        this.restoran = restoran;
        this.kupuvac=kupuvac;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getVreme() {
        return vreme;
    }

    public void setVreme(Timestamp vreme) {
        this.vreme = vreme;
    }

    public Integer getLugje() {
        return lugje;
    }

    public void setLugje(Integer lugje) {
        this.lugje = lugje;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public Kupuvac getKupuvac() {
        return kupuvac;
    }

    public void setKupuvac(Kupuvac kupuvac) {
        this.kupuvac = kupuvac;
    }
}
