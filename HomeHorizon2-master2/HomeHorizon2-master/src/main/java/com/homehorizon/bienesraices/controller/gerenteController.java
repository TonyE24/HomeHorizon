package com.homehorizon.bienesraices.controller;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homehorizon.bienesraices.model.persona.gerente;
import com.homehorizon.bienesraices.model.persona.usuario;
import com.homehorizon.bienesraices.model.propiedad.zonas;
import com.homehorizon.bienesraices.repository.gerenteRepository;
import com.homehorizon.bienesraices.repository.usuarioRepository;
import com.homehorizon.bienesraices.repository.zonaRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/gerentes")
public class gerenteController {
    
    

    @Autowired
    private gerenteRepository GerenteRepository;

    @Autowired
    private usuarioRepository UsuarioRepository;

    @Autowired
    private zonaRepository ZonaRepository;

    public String generarGerenteId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 5);
    }

    @PostMapping("/guardar")
    public String guardarGerente(HttpSession session,
                            @RequestParam("nombre") String nombre,
                            @RequestParam("apellido") String apellido,
                            @RequestParam("correo") String correo,
                            @RequestParam("telefono") String telefono,
                            @RequestParam("fecha_registro") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaRegistro,
                            @RequestParam("estado") boolean estado,
                            @RequestParam("zonaId") Integer zonaId) {

    usuario usuario = (usuario) session.getAttribute("usuario");

    if (usuario == null) {
        return "redirect:/login";
    }

    Integer usuarioId = usuario.getUsuario_id();

    Optional<usuario> usuarioOptional = UsuarioRepository.findById(usuarioId);
    if (usuarioOptional.isEmpty()) {
        return "error";
    }

    usuario usuarioGuardado = usuarioOptional.get();

    Optional<zonas> zonaOptional = ZonaRepository.findById(zonaId);
    if (zonaOptional.isEmpty()) {
        return "error";
    }
    zonas zona = zonaOptional.get();

    gerente nuevoGerente = new gerente();
    nuevoGerente.setGerenteId(generarGerenteId());
    nuevoGerente.setUsuario(usuarioGuardado);
    nuevoGerente.setNombre(nombre);
    nuevoGerente.setApellido(apellido);
    nuevoGerente.setCorreo(correo);
    nuevoGerente.setEstado(estado);
    nuevoGerente.setFechaIngreso(fechaRegistro);
    nuevoGerente.setTelefono(telefono);
    nuevoGerente.setZona(zona);

    GerenteRepository.save(nuevoGerente);
    return "redirect:/configuracion";
}
}

