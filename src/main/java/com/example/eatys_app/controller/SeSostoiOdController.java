package com.example.eatys_app.controller;


import com.example.eatys_app.model.Korisnik;
import com.example.eatys_app.service.SeSostoiOdService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/se-sostoi-od")
public class SeSostoiOdController {

    private final SeSostoiOdService seSostoiOdService;

    public SeSostoiOdController(SeSostoiOdService seSostoiOdService) {
        this.seSostoiOdService = seSostoiOdService;
    }

    @PostMapping("/add-obrok/{id}")
    public String addObrokToShoppingCart(@PathVariable Integer id,@RequestParam Integer kolicina, Authentication authentication, HttpServletRequest req) {
        try {
            String username = req.getRemoteUser();
            this.seSostoiOdService.create(username, id, kolicina);
            return "redirect:/shopping-cart";
        } catch (RuntimeException exception) {
            return "redirect:/shopping-cart?error=" + exception.getMessage();
        }


    }

    @PostMapping("/delete-obrok/{id}")
    public String deleteObrokFromShoppingCart(@PathVariable Integer id, Authentication authentication, HttpServletRequest req) {
        try {
            String username = req.getRemoteUser();
            this.seSostoiOdService.delete(username, id);
            return "redirect:/shopping-cart";
        } catch (RuntimeException exception) {
            return "redirect:/shopping-cart?error=" + exception.getMessage();
        }

    }

    @PostMapping("/payment")
    public String paymentFromShoppingCart(Authentication authentication, HttpServletRequest req) {
        try {
            String username = req.getRemoteUser();
            this.seSostoiOdService.payment(username);
            return "naplata.html";
        } catch (RuntimeException exception) {
            return "redirect:/shopping-cart?error=" + exception.getMessage();
        }

    }


}
