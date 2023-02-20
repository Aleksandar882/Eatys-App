package com.example.eatys_app.controller;


import com.example.eatys_app.model.Korisnik;
import com.example.eatys_app.model.exceptions.InvalidUserCredentialsException;
import com.example.eatys_app.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthService authService;


    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login.html";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        Korisnik user = null;
        try{
             user = this.authService.login(request.getParameter("ime"),
                    request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            return "redirect:/restorani";
        }
        catch (InvalidUserCredentialsException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }
    }
}
