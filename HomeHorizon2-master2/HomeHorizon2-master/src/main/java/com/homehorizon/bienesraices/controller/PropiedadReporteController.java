package com.homehorizon.bienesraices.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homehorizon.bienesraices.model.propiedad.propiedad;
import com.homehorizon.bienesraices.services.PropiedadReporteService;


@Controller
public class PropiedadReporteController {
    @Autowired
    private PropiedadReporteService propiedadReporteService;
 

 @GetMapping("/filtrar")
 public String filtrarPropiedades(
         @RequestParam(required = false) String estado,
         @RequestParam(required = false) String direccion,
         @RequestParam(required = false) String ubicacion,
         @RequestParam(required = false) Integer numHabitaciones,
         @RequestParam(required = false) Double tamañoMin,
         @RequestParam(required = false) Double tamañoMax,
         @RequestParam(required = false) Boolean tieneGarage,
         @RequestParam(required = false) Boolean tienePiscina,
         @RequestParam(required = false) Boolean tieneJardin,
         Model model) {

     Map<String, Object> filtros = new HashMap<>();
     if (estado != null) filtros.put("estado", estado);
     if (direccion != null) filtros.put("direccion", direccion);
     if (ubicacion != null) filtros.put("ubicacion", ubicacion);
     if (numHabitaciones != null) filtros.put("numHabitaciones", numHabitaciones);
     if (tamañoMin != null && tamañoMax != null) {
         filtros.put("tamañoMin", tamañoMin);
         filtros.put("tamañoMax", tamañoMax);
     }
     if (tieneGarage != null) filtros.put("tieneGarage", tieneGarage);
     if (tienePiscina != null) filtros.put("tienePiscina", tienePiscina);
     if (tieneJardin != null) filtros.put("tieneJardin", tieneJardin);

     List<propiedad> propiedades = propiedadReporteService.filtrarPropiedades(filtros);
     model.addAttribute("propiedades", propiedades);
     
    return "reportePropiedad";
    }
 
   
}
