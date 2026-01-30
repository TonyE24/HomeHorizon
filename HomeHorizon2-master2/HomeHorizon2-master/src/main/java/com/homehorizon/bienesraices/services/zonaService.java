package com.homehorizon.bienesraices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homehorizon.bienesraices.model.propiedad.zonas;
import com.homehorizon.bienesraices.repository.zonaRepository;

@Service
public class zonaService {
    @Autowired
    private zonaRepository zonaRepository;

    public List<zonas> listarZonas() {
        return zonaRepository.findAll();
    }
}
