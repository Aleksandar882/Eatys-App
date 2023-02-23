package com.example.eatys_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SeSostoiOdId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "naracka_id", nullable = false)
    private Naracka naracka;

    @ManyToOne
    @JoinColumn(name = "obrok_id", nullable = false)
    private Obrok obrok;

//    public Naracka getNarackaId() {
//        return naracka_id;
//    }
//
//    public void setNarackaId(Naracka narackaId) {
//        this.naracka_id = narackaId;
//    }
//
//    public Obrok getObrokId() {
//        return obrok_id;
//    }
//
//    public void setObrokId(Obrok obrokId) {
//        this.obrok_id = obrokId;
//    }
//
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(naracka_id,obrok_id);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        SeSostoiOdId entity = (SeSostoiOdId) o;
//        return Objects.equals(this.naracka_id, entity.naracka_id) && Objects.equals(this.obrok_id, entity.obrok_id);
//    }
}
