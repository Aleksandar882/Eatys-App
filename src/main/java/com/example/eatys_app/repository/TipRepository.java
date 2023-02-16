package com.example.eatys_app.repository;

import com.example.eatys_app.model.Tip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipRepository extends JpaRepository<Tip,Integer> {
}
