package com.example.Academia.controller;

import com.example.Academia.entity.Plano;
import com.example.Academia.entity.Usuario;
import com.example.Academia.repository.PlanoRepository;
import com.example.Academia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PlanoRepository planoRepository;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/contatos")
    public String contatos(Model model) {
        // Lógica para recuperar informações de contatos do banco de dados (se necessário)
        return "contatos";
    }

    @GetMapping("/cadastro")
    public String cadastroForm(Model model) {
        model.addAttribute("cliente", new Usuario());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarUsuario(@ModelAttribute("cliente") @DateTimeFormat(pattern = "yyyy-MM-dd") Usuario usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/planos";
    }

    @GetMapping("/planos")
    public String planos (Model model){
        return "planos";
    }

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        List<Usuario> clientes = usuarioRepository.findAll();  // Busca todos os clientes com seus planos
        model.addAttribute("clientes", clientes);  // Adiciona a lista de clientes ao modelo
        return "lista-clientes";  // Retorna a página de listagem de clientes com planos
    }

}

