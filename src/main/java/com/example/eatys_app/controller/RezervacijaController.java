package com.example.eatys_app.controller;


import com.example.eatys_app.model.Menadzer;
import com.example.eatys_app.model.Restoran;
import com.example.eatys_app.model.Rezervacija;
import com.example.eatys_app.service.RestoranService;
import com.example.eatys_app.service.RezervacijaService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/rezervacii")
public class RezervacijaController {

    private final RezervacijaService rezervacijaService;
    private final RestoranService restoranService;


    public RezervacijaController(RezervacijaService rezervacijaService, RestoranService restoranService) {
        this.rezervacijaService = rezervacijaService;
        this.restoranService = restoranService;
    }


    @GetMapping
    public String getRezervaciiPage(@RequestParam(required = false) String error,
                                      HttpServletRequest req,
                                      Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        String username = req.getRemoteUser();
        List<Rezervacija> rezervacii= this.rezervacijaService.getActiveRezervacii(username);
        model.addAttribute("rezervacii", rezervacii);
        return "rezervacii.html";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        List<Restoran> restorani=this.restoranService.listAll();
        model.addAttribute("restorani", restorani);
        return "formRezervacija.html";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Integer id, Model model) {
        Rezervacija rezervacija= this.rezervacijaService.findById(id);
        List<Restoran> restorani=this.restoranService.listAll();
        model.addAttribute("rezervacija", rezervacija);
        model.addAttribute("restorani", restorani);
        return "formRezervacija.html";
    }

    @PostMapping("/add-rezervacija/")
    public String addRezervacija(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date vreme,
                                 @RequestParam Integer lugje,
                                 @RequestParam String opis,
                                 @RequestParam Integer restoranId,
                                 Authentication authentication, HttpServletRequest req) {
        try {
            String username = req.getRemoteUser();
            this.rezervacijaService.create(username,vreme,lugje,opis,restoranId);
            return "redirect:/rezervacii";
        } catch (RuntimeException exception) {
            return "redirect:/rezervacii?error=" + exception.getMessage();
        }
    }

    @PostMapping("/add-rezervacija/{id}")
    public String editRezervacija(@PathVariable Integer id,
                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date vreme,
                                 @RequestParam Integer lugje,
                                 @RequestParam String opis,
                                 @RequestParam Integer restoranId,
                                 Authentication authentication, HttpServletRequest req) {
        try {
            String username = req.getRemoteUser();
            this.rezervacijaService.update(id,username,vreme,lugje,opis,restoranId);
            return "redirect:/rezervacii";
        } catch (RuntimeException exception) {
            return "redirect:/rezervacii?error=" + exception.getMessage();
        }
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        this.rezervacijaService.delete(id);
        return "redirect:/rezervacii";
    }

}
