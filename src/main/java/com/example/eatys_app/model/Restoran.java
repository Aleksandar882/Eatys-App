package com.example.eatys_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "restoran", schema = "project")
public class Restoran {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "restoran_id", nullable = false)
        private Integer id;

        @Column(name = "restoran_ime", nullable = false)
        private String ime;

        @Column(name = "restoran_rejting", nullable = false)
        private Integer rejting;

        @Column(name = "restoran_adresa", nullable = false)
        private String adresa;

        @Column(name = "user_id", nullable = false)
        private Integer user_id;

        public Restoran() {
        }

        public Restoran(String ime, Integer rejting, String adresa, Integer user_id) {
                this.ime = ime;
                this.rejting = rejting;
                this.adresa = adresa;
                this.user_id = user_id;
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

        public Integer getUser_id() {
                return user_id;
        }

        public void setUser_id(Integer user_id) {
                this.user_id = user_id;
        }
}
