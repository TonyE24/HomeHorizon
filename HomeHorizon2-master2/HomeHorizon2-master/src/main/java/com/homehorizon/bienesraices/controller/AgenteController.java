package com.homehorizon.bienesraices.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.homehorizon.bienesraices.model.persona.Agente;
import com.homehorizon.bienesraices.model.persona.usuario;
import com.homehorizon.bienesraices.services.AgenteService;
import com.homehorizon.bienesraices.services.tipoUsuarioService;
import com.homehorizon.bienesraices.services.zonaService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/agentes")
public class AgenteController {

    @Autowired
    private AgenteService agenteService;

    @Autowired
    private zonaService zonaService;

    @Autowired
    private tipoUsuarioService tipoUsuarioService;

    private boolean verificarSesion(HttpSession session) {
        Object usuario = session.getAttribute("usuario");
        return usuario != null;
    }

    @GetMapping
    public String listaAgentes(Model model, HttpSession session) {
        if (!verificarSesion(session)) {
            return "redirect:/login"; // Redirige si no está autenticado
        } else {
            List<Agente> agentes = agenteService.obtenerTodosLosAgentes();
            model.addAttribute("listaagentes", agentes);
            return "agente"; // Nombre de tu vista
        }
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model, HttpSession session) {
        if (!verificarSesion(session)) {
            return "redirect:/login"; // Redirige si no está autenticado
        } else {
            model.addAttribute("nuevoagente", new Agente());
            model.addAttribute("zonas", zonaService.listarZonas());
            model.addAttribute("tipousuario", tipoUsuarioService.obtenerTipoUsuarios());
            return "agentemodi";
        }
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") String id, Model model) {
        // Obtener el Agente por ID
        Optional<Agente> obtenerAgente = agenteService.obtenerPorId(id);
        if (!obtenerAgente.isPresent()) {
            return "redirect:/agentes"; // Si el agente no existe, redirige a la lista
        }
        Agente agente = obtenerAgente.get();
        usuario usuario = agente.getUsuario(); // Obtener el usuario asociado

        model.addAttribute("tipousuario", tipoUsuarioService.obtenerTipoUsuarios()); // Cargar tipos de usuario
        model.addAttribute("zonas", zonaService.listarZonas()); // Cargar zonas
        model.addAttribute("nuevousuario", usuario); // Agregar usuario al modelo
        model.addAttribute("nuevoagente", agente); // Agregar agente al modelo

        return "agentemodi"; // Vi
    }

    @PostMapping("/guardar")
    public String guardarAgente(@ModelAttribute("nuevoagente") Agente agente,
            HttpSession session) {
        if (!verificarSesion(session)) {
            return "redirect:/login"; // Redirige si no está autenticado
        } else {
            agenteService.guardarAgente(agente);
            // Redirigir a la lista de agentes después de guardar o editar
            return "redirect:/agentes";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAgente(@PathVariable String id) {
        agenteService.borrarAgente(id);
        return "redirect:/agentes";
    }

}
