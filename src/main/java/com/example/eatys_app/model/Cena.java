package com.example.eatys_app.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="cena", schema = "project")
public class Cena {

    @Id
    @Column(name = "cena_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "obrok_id", nullable = false)
    private Obrok obrok;


    @Column(name = "cena_iznos")
    private Integer CenaIznos;

    @Column(name = "cena_vazi_od")
    private Date CenaVaziOd;

    @Column(name = "cena_vazi_do")
    private Date CenaVaziDo;


    public Cena() {
    }

    public Cena(Obrok obrok, Integer cenaIznos, Date cenaVaziOd, Date cenaVaziDo) {
        this.obrok=obrok;
        CenaIznos = cenaIznos;
        CenaVaziOd = cenaVaziOd;
        CenaVaziDo = cenaVaziDo;
    }

    public Cena(Integer id, Obrok obrok, Integer cenaIznos, Date cenaVaziOd, Date cenaVaziDo) {
        this.id = id;
        this.obrok = obrok;
        CenaIznos = cenaIznos;
        CenaVaziOd = cenaVaziOd;
        CenaVaziDo = cenaVaziDo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Obrok getObrok() {
        return obrok;
    }

    public void setObrok(Obrok obrok) {
        this.obrok = obrok;
    }

    public Integer getCenaIznos() {
        return CenaIznos;
    }

    public void setCenaIznos(Integer cenaIznos) {
        CenaIznos = cenaIznos;
    }

    public Date getCenaVaziOd() {
        return CenaVaziOd;
    }

    public void setCenaVaziOd(Date cenaVaziOd) {
        CenaVaziOd = cenaVaziOd;
    }

    public Date getCenaVaziDo() {
        return CenaVaziDo;
    }

    public void setCenaVaziDo(Date cenaVaziDo) {
        CenaVaziDo = cenaVaziDo;
    }
}
