package com.example.eatys_app.controller;


import com.example.eatys_app.model.exceptions.InvalidArgumentsException;
import com.example.eatys_app.model.exceptions.PasswordsDoNotMatchException;
import com.example.eatys_app.service.AuthService;
import com.example.eatys_app.service.KorisnikService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthService authService;
    private final KorisnikService korisnikService;

    public RegisterController(AuthService authService, KorisnikService korisnikService) {
        this.authService = authService;
        this.korisnikService = korisnikService;
    }


    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        return "register.html";
    }


    @PostMapping
    public String register(@RequestParam String ime,
                           @RequestParam String prezime,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword) {
        try {
            this.korisnikService.register(ime, prezime, password, repeatedPassword);
            return "redirect:/login";
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }
}
