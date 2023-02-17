package com.example.eatys_app.controller;


import com.example.eatys_app.model.Cena;
import com.example.eatys_app.model.Meni;
import com.example.eatys_app.model.Obrok;
import com.example.eatys_app.service.CenaService;
import com.example.eatys_app.service.ObrokService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class CenaController {

    private final CenaService cenaService;
    private final ObrokService obrokService;

    public CenaController(CenaService cenaService, ObrokService obrokService) {
        this.cenaService = cenaService;
        this.obrokService = obrokService;
    }

    @GetMapping( "/ceni" )
    public String showList(Model model){
        List<Obrok> obroci= this.obrokService.listAll();
        List<Cena> ceni= this.cenaService.listAll();

        model.addAttribute("obroci", obroci);
        model.addAttribute("ceni", ceni);
        return "ceni.html";
    }

    @GetMapping("/ceni/add")
    public String showAdd(Model model) {
        List<Obrok> obroci= this.obrokService.listAll();
        model.addAttribute("obroci", obroci);
        return "formCena.html";
    }

    @GetMapping("/ceni/{id}/edit")
    public String showEdit(@PathVariable Integer id, Model model ) {
        Cena cena=this.cenaService.findbyUniqueId(id);
        List<Obrok> obroci= this.obrokService.listAll();
        model.addAttribute("cena", cena);
        model.addAttribute("obroci", obroci);
        return "formCena.html";
    }

    @PostMapping("/ceni/")
    public String create(@RequestParam Integer id,
                         @RequestParam Integer obrokId,
                         @RequestParam Integer cenaIznos,
                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date cenaVaziOd,
                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date cenaVaziDo
    ){
        this.cenaService.create(id,obrokId, cenaIznos,cenaVaziOd,cenaVaziDo);
        return "redirect:/obroci";
    }

    @PostMapping("/ceni/{id}")
    public String edit(  @PathVariable Integer id,
                         @RequestParam Integer obrokId,
                         @RequestParam Integer cenaIznos,
                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date cenaVaziOd,
                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date cenaVaziDo
    ){
        this.cenaService.update(id,obrokId, cenaIznos,cenaVaziOd,cenaVaziDo);
        return "redirect:/obroci";
    }







}
