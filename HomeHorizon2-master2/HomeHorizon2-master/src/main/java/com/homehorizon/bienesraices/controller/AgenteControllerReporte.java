package com.homehorizon.bienesraices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homehorizon.bienesraices.model.persona.Agente;
import com.homehorizon.bienesraices.services.AgenteServiceReporte;



@Controller

public class AgenteControllerReporte {

 @Autowired
private AgenteServiceReporte agenteServiceReporte;

    
    

    @GetMapping("/reporteAgentes")
    public String verReporte(Model modelo, @RequestParam(value="palabra", required= false) String palabra) {
       
        List<Agente> agente= agenteServiceReporte.listAll(palabra);
        modelo.addAttribute("agente",agente);

        return "reporteAgente";
    }
    
    

}
