package com.homehorizon.bienesraices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homehorizon.bienesraices.model.propiedad.propiedad;
import com.homehorizon.bienesraices.repository.propiedadRepository;

@Service
public class propiedadService {
    @Autowired
    private propiedadRepository propiedadRepository;

    public propiedad guardarPropiedad(propiedad propiedad) {
        return propiedadRepository.save(propiedad);
    }

    public List<propiedad> listarPropiedades() {
        return propiedadRepository.findAll();
    }

    public Optional<propiedad> obtenerPorId(String id) {
        return propiedadRepository.findById(id);
    }

    public void borrarPropiedad(String id) {
        if (propiedadRepository.existsById(id)) {
            propiedadRepository.deleteById(id);
        }
    }

}
