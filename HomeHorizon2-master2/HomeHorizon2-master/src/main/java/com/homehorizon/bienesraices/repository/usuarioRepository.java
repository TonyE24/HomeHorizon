package com.homehorizon.bienesraices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homehorizon.bienesraices.model.persona.usuario;

@Repository
public interface usuarioRepository extends JpaRepository<usuario, Integer>{
    usuario findByUsuario(String usuario);
}
