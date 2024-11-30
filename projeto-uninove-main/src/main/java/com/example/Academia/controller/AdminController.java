package com.example.Academia.controller;

import com.example.Academia.entity.Admin;
import com.example.Academia.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/admin")
    public String admin(Model model){return "admin";}

    @GetMapping("/login")
    public String loginForm() {
        return "login";  // retorna a página login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("senha") String senha,
                        Model model) {

        // Verifica se o e-mail e a senha existem no banco de dados
        Optional<Admin> adminOpt = adminRepository.findByEmailAndSenha(email, senha);

        if (adminOpt.isPresent()) {
            return "redirect:/clientes";
        } else {
            model.addAttribute("message", "E-mail ou senha inválidos.");
            return "login";  // retorna a página de login com a mensagem de erro
        }
    }
}
