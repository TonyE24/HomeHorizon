package com.homehorizon.bienesraices.model.asignaciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="interaccion_clientes")
public class interaccionClientes {
    @Id
    @Column(name="interaccion_id")
    private String interaccionId;
    @Column(name="fecha_interaccion")
    private Date fechaInteraccion;
    @Column(name="medio_interaccion")
    private String medioInteraccion;
    @Column(name="razon_interaccion")
    private String razonInteraccion;
    @Column(name="detalle")
    private String detalle;
    @Column(name="fecha_registro")
    private Date fechaRegistro;

    @OneToMany(mappedBy="inteaccionClientes")
    private List<asignacion> asignacion = new ArrayList<>();



    
    public interaccionClientes() {
    }
    public String getInteraccionId() {
        return interaccionId;
    }
    public void setInteraccionId(String interaccionId) {
        this.interaccionId = interaccionId;
    }
    
    public String getMedioInteraccion() {
        return medioInteraccion;
    }
    public void setMedioInteraccion(String medioInteraccion) {
        this.medioInteraccion = medioInteraccion;
    }
    public String getRazonInteraccion() {
        return razonInteraccion;
    }
    public void setRazonInteraccion(String razonInteraccion) {
        this.razonInteraccion = razonInteraccion;
    }
    public String getDetalle() {
        return detalle;
    }
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    public Date getFechaInteraccion() {
        return fechaInteraccion;
    }
    public void setFechaInteraccion(Date fechaInteraccion) {
        this.fechaInteraccion = fechaInteraccion;
    }
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public List<asignacion> getAsignacion() {
        return asignacion;
    }
    public void setAsignacion(List<asignacion> asignacion) {
        this.asignacion = asignacion;
    }
   

    
}
