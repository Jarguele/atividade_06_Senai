package com.seuapp.controller;

import com.seuapp.model.Morador;
import com.seuapp.service.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/moradores")
public class MoradorController {

    private final MoradorService moradorService;

    @Autowired
    public MoradorController(MoradorService moradorService) {
        this.moradorService = moradorService;
    }

    @GetMapping
    public String listarMoradores(Model model) {
        model.addAttribute("moradores", moradorService.listarMoradores());
        return "listagem-moradores";
    }

    // Adicione outros métodos para edição, exclusão e adição de moradores
}
