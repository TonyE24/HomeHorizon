package com.homehorizon.bienesraices.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.homehorizon.bienesraices.model.persona.gerente;

public interface gerenteRepository extends JpaRepository<gerente, String>{
    @Query("SELECT g FROM gerente g WHERE g.usuario.usuario_id = :usuarioId")
    gerente findByUsuarioId(@Param("usuarioId") int usuarioId);
}
