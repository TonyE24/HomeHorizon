package com.homehorizon.bienesraices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homehorizon.bienesraices.model.asignaciones.historialTransacciones;
import com.homehorizon.bienesraices.repository.IHistorialTransaccionesRepositoryReporte;

@Service

public class historialTransaccionesServiceReporte {
 @Autowired
    private IHistorialTransaccionesRepositoryReporte historialTransaccionesRepositoryReporte;

    public List<historialTransacciones> getHistorialForCliente(String clienteId) {
        return historialTransaccionesRepositoryReporte.findByClienteId(clienteId);
    }
}
