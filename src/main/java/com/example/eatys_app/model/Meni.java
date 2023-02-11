package com.example.eatys_app.model;


import jakarta.persistence.*;

@Entity
@Table(name = "meni", schema = "project")
public class Meni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meni_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;


    public Meni() {
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }
}
