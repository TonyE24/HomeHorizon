package com.homehorizon.bienesraices.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.homehorizon.bienesraices.model.propiedad.propiedad;
import com.homehorizon.bienesraices.model.propiedad.propiedadDescripcion;
import com.homehorizon.bienesraices.services.estadoPropiedadService;
import com.homehorizon.bienesraices.services.propiedadService;
import com.homehorizon.bienesraices.services.tipoPropiedadService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("propiedad")
public class PropiedadController {
    @Autowired
    private tipoPropiedadService tipoPropiedadService;

    @Autowired
    private estadoPropiedadService estadoPropiedadService;

    @Autowired
    private propiedadService propiedadService;

    private boolean verificarSesion(HttpSession session) {
        Object usuario = session.getAttribute("usuario");
        return usuario != null;
    }

    @GetMapping
    public String listarPropiedades(Model model, HttpSession session) {
        if (!verificarSesion(session)) {
            return "redirect:/login";
        } else {
            model.addAttribute("listaTipoPropiedad", tipoPropiedadService.obtenerTiposPropiedad());
            model.addAttribute("listaEstadoPropiedad", estadoPropiedadService.obtenerEstadoPropiedad());
            model.addAttribute("listapropiedades", propiedadService.listarPropiedades());
            return "propiedades";
        }
    }

    @GetMapping("/crear")
    public String formularioCrearPropi(Model model, HttpSession session) {
        if (!verificarSesion(session)) {
            return "redirect:/login";

        } else {
            model.addAttribute("nuevapropiedad", new propiedad());
            model.addAttribute("listaTipoPropiedad", tipoPropiedadService.obtenerTiposPropiedad());
            model.addAttribute("listaEstadoPropiedad", estadoPropiedadService.obtenerEstadoPropiedad());
            return "propiedadesmodi";
        }
    }

    @PostMapping("/guardar")
    public String guardarPropiedad(@ModelAttribute("nuevapropiedad") propiedad propiedad,
            HttpSession session) {
        if (!verificarSesion(session)) {
            return "redirect:/login"; // Redirige si no está autenticado
        } else {
            propiedadService.guardarPropiedad(propiedad);
            // Redirigir a la lista de propiedad después de guardar o editar
            return "redirect:/propiedad";
        }
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") String id, Model model) {
        // Obtener el propiedad por ID
        Optional<propiedad> obtenerPropiedad = propiedadService.obtenerPorId(id);
        if (!obtenerPropiedad.isPresent()) {
            return "redirect:/agentes"; // Si el agente no existe, redirige a la lista
        }
        propiedad propi = obtenerPropiedad.get();
        propiedadDescripcion propiDescripcion = propi.getPropiedadDescri(); // Obtener el usuario asociado

        model.addAttribute("listaTipoPropiedad", tipoPropiedadService.obtenerTiposPropiedad());
        model.addAttribute("listaEstadoPropiedad", estadoPropiedadService.obtenerEstadoPropiedad());
        model.addAttribute("nuevapropidesc", propiDescripcion); // Agregar usuario al modelo
        model.addAttribute("nuevapropiedad", propi); // Agregar agente al modelo

        return "propiedadesmodi"; // Vi
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPropiedad(@PathVariable String id) {
        propiedadService.borrarPropiedad(id);
        return "redirect:/propiedad";
    }

}
