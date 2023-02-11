package com.example.eatys_app.model;


import jakarta.persistence.*;



@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name="korisnik", schema = "project")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "user_ime")
    private String ime;

    @Column(name = "user_prezime")
    private String prezime;

    @Column(name = "user_password")
    private String password;




//    @Column(name = "user_admin_id", nullable = false)
//    private Integer admin_id;


    public Korisnik() {
    }

    public Korisnik(String ime, String prezime, String password) {
        this.ime = ime;
        this.prezime = prezime;
        this.password = password;
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

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
