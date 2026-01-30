package com.homehorizon.bienesraices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homehorizon.bienesraices.model.propiedad.tipoPropiedad;
import com.homehorizon.bienesraices.repository.tipoPropiedadRepository;

@Service
public class tipoPropiedadService {
    @Autowired
    private tipoPropiedadRepository tipoPropiedadRepository;

    public List<tipoPropiedad> obtenerTiposPropiedad() {
        return tipoPropiedadRepository.findAll();
    }
}
