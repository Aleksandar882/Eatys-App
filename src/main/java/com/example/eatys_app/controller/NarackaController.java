package com.example.eatys_app.controller;

import com.example.eatys_app.model.Korisnik;
import com.example.eatys_app.model.Naracka;
import com.example.eatys_app.service.NarackaService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shopping-cart")
public class NarackaController {

    private final NarackaService narackaService;

    public NarackaController(NarackaService narackaService) {
        this.narackaService = narackaService;
    }

    @GetMapping
    public String getShoppingCartPage(@RequestParam(required = false) String error,
                                      HttpServletRequest req,
                                      Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        String username = req.getRemoteUser();
        Naracka shoppingCart = this.narackaService.getActiveShoppingCart(username);
//        double prices=this.narackaService.getPrice(shoppingCart.getId());
//        model.addAttribute("amount", (int)prices * 100); // in cents
        int prices=this.narackaService.Total(shoppingCart.getId());
        model.addAttribute("obroci", this.narackaService.listAllObrociInShoppingCart(shoppingCart.getId()));
        model.addAttribute("amount", prices);
        return "shopping-cart.html";
    }

    @PostMapping("/add-obrok/{id}")
    public String addObrokToShoppingCart(@PathVariable Integer id, HttpServletRequest req, Authentication authentication) {

            try {
                String username = req.getRemoteUser();
                this.narackaService.addObrokToShoppingCart(username, id);
                return "redirect:/shopping-cart";
            } catch (RuntimeException exception) {
                return "redirect:/shopping-cart?error=" + exception.getMessage();
            }



    }

}
