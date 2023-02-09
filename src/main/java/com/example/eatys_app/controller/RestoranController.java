package com.example.eatys_app.controller;

import com.example.eatys_app.repository.RestoranRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestoranController {

    private final RestoranRepository restoranRepository;

    public RestoranController(RestoranRepository restoranRepository) {
        this.restoranRepository = restoranRepository;
    }


    @RequestMapping("/restoran")
    public ResponseEntity getAllRestorani(){
        return ResponseEntity.ok(this.restoranRepository.findAll());
    }
}