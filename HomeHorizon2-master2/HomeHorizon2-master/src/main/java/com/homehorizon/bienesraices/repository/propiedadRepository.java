package com.homehorizon.bienesraices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homehorizon.bienesraices.model.propiedad.propiedad;

public interface propiedadRepository extends JpaRepository<propiedad, String> {

}
