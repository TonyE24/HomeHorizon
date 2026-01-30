package com.homehorizon.bienesraices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.homehorizon.bienesraices.model.persona.Agente;

@Repository
public interface AgenteRepository extends JpaRepository <Agente, String>{
    @Query("SELECT a FROM Agente a WHERE a.usuario.usuario_id = :usuarioId")
    Agente findByUsuarioId(@Param("usuarioId")int usuarioId);
}

