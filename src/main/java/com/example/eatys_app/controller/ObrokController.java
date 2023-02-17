package com.example.eatys_app.controller;

import com.example.eatys_app.model.Cena;
import com.example.eatys_app.model.Meni;
import com.example.eatys_app.model.Obrok;
import com.example.eatys_app.service.CenaService;
import com.example.eatys_app.service.MeniService;
import com.example.eatys_app.service.ObrokService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ObrokController {

    private final ObrokService obrokService;
    private final MeniService meniService;
    private final CenaService cenaService;


    public ObrokController(ObrokService obrokService, MeniService meniService, CenaService cenaService) {
        this.obrokService = obrokService;
        this.meniService = meniService;
        this.cenaService = cenaService;
    }

    @GetMapping( "/obroci" )
    public String showList(Model model){
        List<Obrok> obroci= this.obrokService.listAll();
        List<Meni> menija= this.meniService.listAll();
        List<Cena> ceni= this.cenaService.listAll();

        model.addAttribute("obroci", obroci);
        model.addAttribute("menija", menija);
        model.addAttribute("ceni", ceni);
        return "obroci.html";
    }

    @GetMapping("/obroci/add")
    public String showAdd(Model model) {
        List<Cena> ceni= this.cenaService.listAll();
        List<Meni> menija= this.meniService.listAll();
        model.addAttribute("menija", menija);
        model.addAttribute("ceni", ceni);
        return "formObrok.html";
    }

    @GetMapping("/obroci/{id}/edit")
    public String showEdit(@PathVariable Integer id, Model model) {
        Obrok obrok =this.obrokService.findById(id);
        List<Meni> menija= this.meniService.listAll();
        List<Cena> ceni= this.cenaService.listAll();
        model.addAttribute("obrok", obrok);
        model.addAttribute("menija", menija);
        model.addAttribute("ceni", ceni);
        return "formObrok.html";
    }

    @PostMapping("/obroci/")
    public String create(@RequestParam String ime,
                         @RequestParam String opis,
                         @RequestParam Integer meniId
    ){
        this.obrokService.create(ime,opis,meniId);
        return "redirect:/ceni/add";
    }



    @PostMapping("/obroci/{id}")
    public String update(@PathVariable Integer id,
                         @RequestParam String ime,
                         @RequestParam String opis,
                         @RequestParam Integer meniId
    ){
        this.obrokService.update(id,ime,opis,meniId);
        return "redirect:/obroci";
    }

    @PostMapping("/obroci/{id}/delete")
    public String delete(@PathVariable Integer id) {
        this.obrokService.delete(id);
        return "redirect:/obroci";
    }





}
