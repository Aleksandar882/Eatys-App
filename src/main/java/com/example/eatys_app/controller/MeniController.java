package com.example.eatys_app.controller;

import com.example.eatys_app.model.Meni;
import com.example.eatys_app.model.Obrok;
import com.example.eatys_app.model.Restoran;
import com.example.eatys_app.model.Tip;
import com.example.eatys_app.service.MeniService;
import com.example.eatys_app.service.ObrokService;
import com.example.eatys_app.service.RestoranService;
import com.example.eatys_app.service.TipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MeniController {

    private final MeniService meniService;
    private final RestoranService restoranService;
    private final TipService tipService;


    public MeniController(MeniService meniService, RestoranService restoranService, TipService tipService) {
        this.meniService = meniService;
        this.restoranService = restoranService;
        this.tipService = tipService;

    }

    @GetMapping( "/menija" )
    public String showList(Model model){
        List<Meni> menija= this.meniService.listAll();
        List<Restoran> restorani= this.restoranService.listAll();
        List<Tip>tipovi=this.tipService.listAll();



        model.addAttribute("menija", menija);
        model.addAttribute("restorani", restorani);
        model.addAttribute("tipovi", tipovi);


        return "menija.html";
    }

    @GetMapping("/menija/add")
    public String showAdd(Model model) {
        List<Restoran> restorani= this.restoranService.listAll();
        List<Tip>tipovi=this.tipService.listAll();
        model.addAttribute("restorani", restorani);
        model.addAttribute("tipovi", tipovi);
        return "formMeni.html";
    }

    @GetMapping("/menija/{id}/edit")
    public String showEdit(@PathVariable Integer id, Model model) {
        Meni meni=this.meniService.findById(id);
        List<Restoran> restorani= this.restoranService.listAll();
        List<Tip>tipovi=this.tipService.listAll();
        model.addAttribute("meni", meni);
        model.addAttribute("restorani", restorani);
        model.addAttribute("tipovi", tipovi);
        return "formMeni.html";
    }

    @PostMapping("/menija/")
    public String create(@RequestParam Integer tipId,
                         @RequestParam Integer restoranId
    ){
        this.meniService.create(tipId, restoranId);
        return "redirect:/menija";
    }

    @PostMapping("/menija/{id}")
    public String update(@PathVariable Integer id,
                         @RequestParam Integer tipId,
                         @RequestParam Integer restoranId
    ){
        this.meniService.update( id,tipId, restoranId);
        return "redirect:/menija";
    }

    @PostMapping("/menija/{id}/delete")
    public String delete(@PathVariable Integer id) {
        this.meniService.delete(id);
        return "redirect:/menija";
    }



}
