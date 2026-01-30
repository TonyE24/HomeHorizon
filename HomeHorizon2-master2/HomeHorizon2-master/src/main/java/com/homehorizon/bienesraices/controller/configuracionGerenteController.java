package com.homehorizon.bienesraices.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homehorizon.bienesraices.model.persona.usuario;
import com.homehorizon.bienesraices.model.propiedad.zonas;
import com.homehorizon.bienesraices.repository.gerenteRepository;
import com.homehorizon.bienesraices.repository.zonaRepository;
import com.homehorizon.bienesraices.services.usuarioService;
import com.homehorizon.bienesraices.model.persona.gerente;

import jakarta.servlet.http.HttpSession;



@Controller
public class configuracionGerenteController {

    @Autowired
    private gerenteRepository gerenteRepository;

    @Autowired
    private zonaRepository zonaRepository;

    @Autowired
    private usuarioService usuarioService;

    @GetMapping("/configuracion")
    public String mostrarConfiguracion(HttpSession session, Model model) {
        usuario usuarioActivo = (usuario) session.getAttribute("usuario");

        if(usuarioActivo == null){
            return "redirect:/login";
        }

        gerente gerente = gerenteRepository.findByUsuarioId(usuarioActivo.getUsuario_id());
        
        if(gerente != null){
            model.addAttribute("gerente", gerente);
        }else{
            model.addAttribute("gerente", null);
            model.addAttribute("error", "No se encontro informacion del gerente");
        }
        return "configuracion";
    }

    @GetMapping("/configuracionGerente")
    public String mostrarFormulario(HttpSession session, Model model){
        usuario usuarioActivo = (usuario) session.getAttribute("usuario");

        if(usuarioActivo == null){
            return "redirect:/login";
        }

        gerente gerenteExistente = gerenteRepository.findByUsuarioId(usuarioActivo.getUsuario_id());
        System.out.println("el usuario  " + gerenteExistente);
        if (gerenteExistente != null) {
            
            return "redirect:/configuracion"; 
        } else {
            // Si el gerente no existe, continuar en la página configuracionGerente
            model.addAttribute("isGerenteExists", false);
            List<zonas> listaZonas = zonaRepository.findAll();

            model.addAttribute("zonas", listaZonas);
            return "configuracionGerente";
        }

    }

    @PostMapping("/verificarContra")
    public String verificarContra(@RequestParam String contraseña, HttpSession session, Model model){
        usuario user = (usuario) session.getAttribute("usuario");
        if(user == null){
            model.addAttribute("error", "Usuario no autenticado. Inicia Sesion nuevamente");
            return "redirect:/login";
        }
        Integer usuarioId = user.getUsuario_id();

        if(usuarioService.verificarContra(usuarioId, contraseña)){
            session.setAttribute("contraVerificada", true);
            model.addAttribute("mensaje", "contraseña verificada correctamente");
        }else{
            model.addAttribute("error", "la contraseña ingresada es incorrecta");
        }
        return "cambioContra";
    }

    @PostMapping("/cambioContra")
    public String cambiarContra(@RequestParam String Ncontraseña, HttpSession session, Model model){
        usuario user = (usuario) session.getAttribute("usuario");
        if (user == null) {
            model.addAttribute("error", "Usuario no autenticado. Inicia sesión nuevamente");
            return "redirect:/login";
        }
        
        Integer usuarioId = user.getUsuario_id();
        Boolean verificada = (Boolean) session.getAttribute("contraVerificada");

        if(Boolean.TRUE.equals(verificada)){
            if(usuarioService.cambiarContra(usuarioId, Ncontraseña)){
                session.removeAttribute("contraVerificada");
                model.addAttribute("mensaje", "Contraseña cambiada exitosamente");
            }else{
                model.addAttribute("error", "Error al cambiar la contraseña");
            }
        }else{
            model.addAttribute("error", "Debe verificar su contraseña actual antes de cambiarla");
        }
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/cambioContra")
    public String formularioCambioContra(HttpSession session, Model model){
        usuario user = (usuario) session.getAttribute("usuario");
        if (user != null) {
            model.addAttribute("usuarioId", user.getUsuario_id()); 
            return "cambioContra";
        } else {
            model.addAttribute("error", "Debes iniciar sesión para acceder a esta página.");
            return "redirect:/login";
        }
    }
     
}
