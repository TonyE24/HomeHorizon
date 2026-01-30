package com.homehorizon.bienesraices.model.asignaciones;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "calendario")
public class calendario {
    @Id
    @Column(name="evento_id")
    private String eventoId;

    @ManyToOne
    @JoinColumn(name="asignacion_id")
    private asignacion asignacion;
    //private String asignacionId;
    @Column(name="titulo")
    private String titulo;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="fecha")
    private Date fecha;
    @Column(name="hora")
    private Time hora;

    public calendario() {
    }



    public String getEventoId() {
        return eventoId;
    }

    public void setEventoId(String eventoId) {
        this.eventoId = eventoId;
    }

    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }



    public asignacion getAsignacion() {
        return asignacion;
    }



    public void setAsignacion(asignacion asignacion) {
        this.asignacion = asignacion;
    }



    public Date getFecha() {
        return fecha;
    }



    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    



}
