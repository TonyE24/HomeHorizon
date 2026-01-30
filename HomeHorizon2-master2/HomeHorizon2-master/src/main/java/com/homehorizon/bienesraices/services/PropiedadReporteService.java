package com.homehorizon.bienesraices.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homehorizon.bienesraices.model.propiedad.propiedad;
import com.homehorizon.bienesraices.repository.PropiedadRepositoryCustom;

@Service
public class PropiedadReporteService {
    @Autowired
private PropiedadRepositoryCustom propiedadRepository;

    public List<propiedad> filtrarPropiedades(Map<String, Object> filtros) {
        return propiedadRepository.buscarPropiedadesDinamicamente(filtros);
    }
}
