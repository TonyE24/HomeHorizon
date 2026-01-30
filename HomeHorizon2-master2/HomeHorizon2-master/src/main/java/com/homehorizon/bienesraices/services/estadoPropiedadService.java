package com.homehorizon.bienesraices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homehorizon.bienesraices.model.propiedad.estadoPropiedad;
import com.homehorizon.bienesraices.repository.estadoPropiedadRepository;

@Service
public class estadoPropiedadService {
    @Autowired
    private estadoPropiedadRepository estadoPropiedadRepository;

    public List<estadoPropiedad> obtenerEstadoPropiedad() {
        return estadoPropiedadRepository.findAll();
    }
}