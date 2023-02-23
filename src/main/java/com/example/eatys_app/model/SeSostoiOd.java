package com.example.eatys_app.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "se_sostoi_od", schema = "project")
@IdClass(SeSostoiOdId.class)
public class SeSostoiOd {

//    @EmbeddedId
//    @AttributeOverrides({ @AttributeOverride(name = "naracka_id", column = @Column(name =
//            "naracka_id", nullable = false)),
//            @AttributeOverride(name = "obrok_id", column = @Column(name = "obrok_id", nullable = false)) })
//    SeSostoiOdId id;


    @Id
    @ManyToOne
    @JoinColumn(name = "naracka_id", nullable = false)
    private Naracka naracka;


    @Id
    @ManyToOne
    @JoinColumn(name = "obrok_id", nullable = false)
    private Obrok obrok;

    @Column(name = "kolicina", nullable = false)
    private Integer kolicina;

    @Column(name = "cena", nullable = false)
    private Integer cena;

    public SeSostoiOd() {
    }

    public SeSostoiOd(Naracka naracka, Obrok obrok, Integer kolicina, Integer cena) {
        this.naracka = naracka;
        this.obrok = obrok;
        this.kolicina = kolicina;
        this.cena = cena;
    }

    public SeSostoiOd(SeSostoiOdId id, Naracka naracka, Obrok obrok, Integer kolicina, Integer cena) {
//        this.id = id;
        this.naracka = naracka;
        this.obrok = obrok;
        this.kolicina = kolicina;
        this.cena = cena;
    }

//    public SeSostoiOdId getId() {
//        return id;
//    }
//
//    public void setId(SeSostoiOdId id) {
//        this.id = id;
//    }

    public Naracka getNaracka() {
        return naracka;
    }

    public void setNaracka(Naracka naracka) {
        this.naracka = naracka;
    }

    public Obrok getObrok() {
        return obrok;
    }

    public void setObrok(Obrok obrok) {
        this.obrok = obrok;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

//    public Integer getNarackaId() {
//        return narackaId;
//    }
//
//    public void setNarackaId(Integer narackaId) {
//        this.narackaId = narackaId;
//    }
//
//    public Integer getObrokId() {
//        return obrokId;
//    }
//
//    public void setObrokId(Integer obrokId) {
//        this.obrokId = obrokId;
//    }
}
