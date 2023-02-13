package com.example.eatys_app.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "restoran", schema = "project")
public class Restoran {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "restoran_id", nullable = false)
        private Integer id;

        @Column(name = "restoran_ime")
        private String ime;

        @Column(name = "restoran_rejting")
        private Integer rejting;

        @Column(name = "restoran_adresa")
        private String adresa;


        @OneToOne
        @JoinColumn(name = "user_id")
        private Menadzer menadzer;



        public Restoran() {
        }



        public Restoran(String ime, Integer rejting, String adresa, Menadzer menadzer) {
                this.ime = ime;
                this.rejting = rejting;
                this.adresa = adresa;
                this.menadzer = menadzer;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getIme() {
                return ime;
        }

        public void setIme(String ime) {
                this.ime = ime;
        }

        public Integer getRejting() {
                return rejting;
        }

        public void setRejting(Integer rejting) {
                this.rejting = rejting;
        }

        public String getAdresa() {
                return adresa;
        }

        public void setAdresa(String adresa) {
                this.adresa = adresa;
        }

        public Menadzer getMenadzer() {
                return menadzer;
        }

        public void setMenadzer(Menadzer menadzer) {
                this.menadzer = menadzer;
        }


}
