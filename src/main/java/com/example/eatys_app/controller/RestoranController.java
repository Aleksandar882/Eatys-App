package com.example.eatys_app.controller;

import com.example.eatys_app.model.Menadzer;
import com.example.eatys_app.model.Restoran;
import com.example.eatys_app.service.MenadzerService;
import com.example.eatys_app.service.RestoranService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Controller
public class RestoranController {

    private final RestoranService restoranService;
    private final MenadzerService menadzerService;

    public RestoranController(RestoranService restoranService, MenadzerService menadzerService) {
        this.restoranService = restoranService;
        this.menadzerService = menadzerService;
    }


    @GetMapping({"/", "/restorani" })
    public String showList(Model model){
        List<Restoran> restorani= this.restoranService.listAll();
        List<Menadzer>menadzeri=this.menadzerService.listAll();


        model.addAttribute("restorani", restorani);
        model.addAttribute("menadzeri", menadzeri);

        return "restorani.html";
    }

    @GetMapping("/restorani/add")
    public String showAdd(Model model) {
        List<Menadzer> menadzeri=this.menadzerService.listAll();
        model.addAttribute("menadzeri", menadzeri);
        return "form.html";
    }

    @GetMapping("/restorani/{id}/edit")
    public String showEdit(@PathVariable Integer id, Model model) {
        Restoran restoran= this.restoranService.findById(id);
        List<Menadzer> menadzeri=this.menadzerService.listAll();
        model.addAttribute("restoran", restoran);
        model.addAttribute("menadzeri", menadzeri);
        return "form.html";
    }

    @PostMapping("/restorani/")
    public String create(@RequestParam String ime,
                         @RequestParam Integer rejting,
                         @RequestParam String adresa,
                         @RequestParam Integer menadzerId
                         ){
        this.restoranService.create(ime, rejting, adresa, menadzerId);
        return "redirect:/restorani";
    }

    @PostMapping("/restorani/{id}")
    public String update(@PathVariable Integer id,
                         @RequestParam String ime,
                         @RequestParam Integer rejting,
                         @RequestParam String adresa,
                         @RequestParam Integer menadzerId
                        ){
        this.restoranService.update(id, ime, rejting, adresa, menadzerId);
        return "redirect:/restorani";
    }

    @PostMapping("/restorani/{id}/delete")
    public String delete(@PathVariable Integer id) {
        this.restoranService.delete(id);
        return "redirect:/restorani";
    }

}