package com.homehorizon.bienesraices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homehorizon.bienesraices.model.propiedad.zonas;

@Repository
public interface zonaRepository extends JpaRepository<zonas , Integer>{

}
