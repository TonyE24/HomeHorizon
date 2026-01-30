package com.homehorizon.bienesraices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.homehorizon.bienesraices.model.asignaciones.historialTransacciones;

public interface IHistorialTransaccionesRepositoryReporte  extends JpaRepository<historialTransacciones, String> {
 @Query("SELECT h FROM historialTransacciones h WHERE h.cliente.cliente_id = :clienteId")
 
    List<historialTransacciones> findByClienteId(@Param("clienteId") String clienteId);
}
