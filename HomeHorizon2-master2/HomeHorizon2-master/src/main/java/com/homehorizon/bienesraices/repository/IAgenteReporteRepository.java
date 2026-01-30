package com.homehorizon.bienesraices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.homehorizon.bienesraices.model.persona.Agente;


@Repository
public interface IAgenteReporteRepository extends JpaRepository<Agente, String> {


    @Query("SELECT a FROM Agente a WHERE " +
           "a.agente_id LIKE %:valor% OR " +
           "CONCAT(a.nombre, ' ', a.apellido) LIKE %:valor% OR " +
           "a.nombre LIKE %:valor% OR " +
           "a.apellido LIKE %:valor% OR " +
           "a.correo LIKE %:valor% OR " +
           "a.telefono LIKE %:valor% OR " +
           "STR(a.fecha_ingreso) LIKE %:valor% OR " +
           "STR(a.zona.zona) LIKE %:valor%")
    List<Agente> buscarPorValor(String valor);

    

}
