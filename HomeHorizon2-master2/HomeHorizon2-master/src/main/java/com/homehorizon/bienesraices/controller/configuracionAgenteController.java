package com.homehorizon.bienesraices.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.homehorizon.bienesraices.model.persona.Agente;
import com.homehorizon.bienesraices.model.persona.usuario;
import com.homehorizon.bienesraices.services.AgenteService;

import jakarta.servlet.http.HttpSession;

@Controller
public class configuracionAgenteController {

    @Autowired
    private AgenteService agenteService;

    @GetMapping("/configuracionAgente")
    public String mostrarConfiguracion(Model model, HttpSession session){
        usuario usuarioActivo = (usuario) session.getAttribute("usuario");
        if(usuarioActivo == null){
            return "redirect:/login";
        }

        Agente agente = agenteService.obtenerPorUsuario(usuarioActivo.getUsuario_id());
        System.out.println(agente);
        if(agente==null){
            model.addAttribute("error", "No se encontro informacion del agente asociado.");
            return "indexAgente";
        }
        model.addAttribute("agente", agente);
        return "configuracionAgente";
    }  
}
