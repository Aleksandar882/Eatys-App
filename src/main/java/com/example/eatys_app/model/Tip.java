package com.example.eatys_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tip", schema = "project")
public class Tip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tip_id", nullable = false)
    private Integer Id;

    @Column(name = "tip_ime", nullable = false)
    private String ime;

    public Tip() {
    }

    public Tip(String ime) {
        this.ime = ime;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}
