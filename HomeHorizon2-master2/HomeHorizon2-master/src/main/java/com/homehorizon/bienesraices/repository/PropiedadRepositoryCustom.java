package com.homehorizon.bienesraices.repository;

import java.util.List;
import java.util.Map;


import com.homehorizon.bienesraices.model.propiedad.propiedad;

public interface PropiedadRepositoryCustom {
    List<propiedad> buscarPropiedadesDinamicamente(Map<String, Object> filtros);
}
