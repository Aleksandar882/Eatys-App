package com.example.eatys_app.repository;

import com.example.eatys_app.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<Korisnik,Integer> {

    @Query("SELECT u FROM Korisnik u WHERE u.ime = :ime")
    public Korisnik getKorisnikByIme(@Param("ime") String ime);

    Optional<Korisnik> findByImeAndPassword(String ime, String password);

    Optional<Korisnik> findByIme(String ime);

}
