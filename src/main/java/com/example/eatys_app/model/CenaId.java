package com.example.eatys_app.model;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CenaId implements Serializable {

    @MapsId("ObrokId")
    @ManyToOne
    @JoinColumn(name = "obrok_id", nullable = false)
    private Obrok ObrokId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cena_id")
    private Integer CenaId;

    public CenaId() {
    }

    public CenaId(Obrok ObrokId, Integer CenaId) {
        this.ObrokId = ObrokId;
        this.CenaId = CenaId;
    }

    public Obrok getObrokId() {
        return ObrokId;
    }

    public void setObrokId(Obrok ObrokId) {
        this.ObrokId = ObrokId;
    }

    public Integer getCenaId() {
        return CenaId;
    }

    public void setCenaId(Integer CenaId) {
        this.CenaId = CenaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CenaId entity = (CenaId) o;
        return Objects.equals(this.ObrokId, entity.ObrokId) &&
                Objects.equals(this.CenaId, entity.CenaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ObrokId, CenaId);
    }
}

