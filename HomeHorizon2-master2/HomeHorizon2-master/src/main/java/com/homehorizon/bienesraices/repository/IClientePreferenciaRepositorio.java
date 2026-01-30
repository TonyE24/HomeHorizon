package com.homehorizon.bienesraices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homehorizon.bienesraices.model.persona.Preferencia;

public interface IClientePreferenciaRepositorio extends JpaRepository<Preferencia, Integer> {
}
