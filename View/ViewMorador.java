package com.seuapp.view;

import com.seuapp.person.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MoradorViewController {

    private final MoradorService moradorService;

    @Autowired
    public MoradorViewController(MoradorService moradorService) {
        this.moradorService = moradorService;
    }

    @GetMapping("/moradores")
    public String listarMoradores(Model model) {
        model.addAttribute("moradores", moradorService.listarMoradores());
        return "morador/list";
    }

    @GetMapping("/moradores/{id}/editar")
    public String editarMorador(@PathVariable Long id, Model model) {
        Morador morador = moradorService.buscarMoradorPorId(id);
        model.addAttribute("morador", morador);
        return "morador/edit";
    }

    // Adicione outros métodos para adicionar, excluir e buscar moradores
}
