package com.homehorizon.bienesraices.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.homehorizon.bienesraices.model.propiedad.propiedad;
import com.homehorizon.bienesraices.model.propiedad.propiedadDescripcion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class PropiedadRepositoryCustomImpl implements PropiedadRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<propiedad> buscarPropiedadesDinamicamente(Map<String, Object> filtros) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<propiedad> query = cb.createQuery(propiedad.class);
        Root<propiedad> propiedad = query.from(propiedad.class);
        Join<propiedad, propiedadDescripcion> descripcion = propiedad.join("propiedadDescripcioin", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();

        // Filtros dinámicos
        if (filtros.containsKey("estado") && filtros.get("estado") != null) {
            predicates.add(cb.equal(propiedad.get("estadoPropiedad").get("estadoId"), filtros.get("estado")));
        }
        if (filtros.containsKey("direccion") && filtros.get("direccion") != null
                && !filtros.get("direccion").toString().isEmpty()) {
            predicates.add(cb.like(cb.lower(propiedad.get("direccion")),
                    "%" + filtros.get("direccion").toString().toLowerCase() + "%"));
        }
        if (filtros.containsKey("ubicacion") && filtros.get("ubicacion") != null
                && !filtros.get("ubicacion").toString().isEmpty()) {
            predicates.add(cb.like(cb.lower(propiedad.get("ubicacion")),
                    "%" + filtros.get("ubicacion").toString().toLowerCase() + "%"));
        }
        if (filtros.containsKey("numHabitaciones") && filtros.get("numHabitaciones") != null) {
            predicates.add(cb.equal(descripcion.get("numHabitaciones"), filtros.get("numHabitaciones")));
        }
        if (filtros.containsKey("tamañoMin") && filtros.containsKey("tamañoMax") && filtros.get("tamañoMin") != null
                && filtros.get("tamañoMax") != null) {
            predicates.add(cb.between(descripcion.get("tamaño"),
                    (Double) filtros.get("tamañoMin"),
                    (Double) filtros.get("tamañoMax")));
        }
        if (filtros.containsKey("tieneGarage") && filtros.get("tieneGarage") != null) {
            predicates.add(cb.equal(descripcion.get("garaje"), filtros.get("tieneGarage")));
        }
        if (filtros.containsKey("tienePiscina") && filtros.get("tienePiscina") != null) {
            predicates.add(cb.equal(descripcion.get("piscina"), filtros.get("tienePiscina")));
        }
        if (filtros.containsKey("tieneJardin") && filtros.get("tieneJardin") != null) {
            predicates.add(cb.equal(descripcion.get("jardin"), filtros.get("tieneJardin")));
        }

        if (predicates.isEmpty()) {
            query.where(cb.conjunction());
        } else {
            query.where(cb.and(predicates.toArray(new Predicate[0])));
        }

        return entityManager.createQuery(query).getResultList();

    }

}
