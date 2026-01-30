package com.homehorizon.bienesraices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homehorizon.bienesraices.model.persona.Cliente;

public interface IClienteRepositorio extends JpaRepository<Cliente, String>{
    List<Cliente> findByNombreContainingIgnoreCase(String nombre);

}
