package com.example.eatys_app.controller;

import com.example.eatys_app.model.Meni;
import com.example.eatys_app.model.Obrok;
import com.example.eatys_app.model.Restoran;
import com.example.eatys_app.model.Tip;
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


    public ObrokController(ObrokService obrokService, MeniService meniService) {
        this.obrokService = obrokService;
        this.meniService = meniService;
    }

    @GetMapping( "/obroci" )
    public String showList(Model model){
        List<Obrok> obroci= this.obrokService.listAll();
        List<Meni> menija= this.meniService.listAll();


        model.addAttribute("obroci", obroci);
        model.addAttribute("menija", menija);

        return "obroci.html";
    }

    @GetMapping("/obroci/add")
    public String showAdd(Model model) {
        List<Meni> menija= this.meniService.listAll();
        model.addAttribute("menija", menija);
        return "formObrok.html";
    }

    @GetMapping("/obroci/{id}/edit")
    public String showEdit(@PathVariable Integer id, Model model) {
        Obrok obrok =this.obrokService.findById(id);
        List<Meni> menija= this.meniService.listAll();
        model.addAttribute("obrok", obrok);
        model.addAttribute("menija", menija);
        return "formObrok.html";
    }

    @PostMapping("/obroci/")
    public String create(@RequestParam String ime,
                         @RequestParam String opis,
                         @RequestParam Integer meniId
    ){
        this.obrokService.create(ime,opis,meniId);
        return "redirect:/obroci";
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
