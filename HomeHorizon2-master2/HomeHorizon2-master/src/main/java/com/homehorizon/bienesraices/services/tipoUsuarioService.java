package com.homehorizon.bienesraices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homehorizon.bienesraices.model.persona.tipoUsuario;
import com.homehorizon.bienesraices.repository.tipoUsuarioRepository;

@Service
public class tipoUsuarioService {
    @Autowired
    private tipoUsuarioRepository tipoUsuarioRepository;

    public List<tipoUsuario> obtenerTipoUsuarios() {
        return tipoUsuarioRepository.findAll();
    }
}
