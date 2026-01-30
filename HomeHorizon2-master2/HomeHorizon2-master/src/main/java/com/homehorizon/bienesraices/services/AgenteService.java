package com.homehorizon.bienesraices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.homehorizon.bienesraices.model.persona.Agente;
import com.homehorizon.bienesraices.repository.AgenteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AgenteService {

    @Autowired
    private AgenteRepository agenteRepository;

    // Crear o guardar un agente
    public Agente guardarAgente(Agente agente) {

        return agenteRepository.save(agente);
    }

    // Leer todos los agentes
    public List<Agente> obtenerTodosLosAgentes() {
        return agenteRepository.findAll();
    }

    // Leer un agente por ID
    public Optional<Agente> obtenerPorId(String id) {
        return agenteRepository.findById(id);
    }

    // Borrar un agente
    public void borrarAgente(String id) {
        if (agenteRepository.existsById(id)) {
            agenteRepository.deleteById(id);
        }
    }

    public Agente obtenerPorUsuario(int usuarioId) {
        return agenteRepository.findByUsuarioId(usuarioId);
    }
}
