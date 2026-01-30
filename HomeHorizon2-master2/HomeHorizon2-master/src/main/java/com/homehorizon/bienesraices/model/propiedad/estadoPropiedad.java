package com.homehorizon.bienesraices.model.propiedad;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estado_propiedad")
public class estadoPropiedad {
    @Id
    @Column(name = "estado_id")
    private Long estadoId;
    @Column(name = "nombre_estado")
    private String nombreEstado;
    @Column(name = "descripcion")
    private String descripcion = null;
    @Column(name = "monto")
    private Double monto = null;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion = null;
    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion = null;

    public estadoPropiedad() {
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

}
