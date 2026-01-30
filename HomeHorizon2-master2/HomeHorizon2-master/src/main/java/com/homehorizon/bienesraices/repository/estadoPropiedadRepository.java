package com.homehorizon.bienesraices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homehorizon.bienesraices.model.propiedad.estadoPropiedad;

public interface estadoPropiedadRepository extends JpaRepository<estadoPropiedad, Long> {

}
