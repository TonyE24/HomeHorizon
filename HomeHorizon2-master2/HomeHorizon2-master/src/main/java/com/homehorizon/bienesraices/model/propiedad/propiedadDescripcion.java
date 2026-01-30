package com.homehorizon.bienesraices.model.propiedad;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "descripcion_propiedad")
public class propiedadDescripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "descripcion_id")
    private Long descripcionId;
    @Column(name = "descripcion")
    @NotBlank(message = "La descripción es necesaria")
    @Size(min = 10, max = 500, message = "La descripción debe tener entre 10 y 500 caracteres")
    private String descripcion;

    @Column(name = "num_habitaciones")
    @Min(value = 1, message = "El número de habitaciones debe ser mayor o igual a 1")
    @Max(value = 10, message = "El número de habitaciones debe ser menor o igual a 10")
    private int numHabitaciones;

    @Column(name = "num_baños")
    @Min(value = 1, message = "El número de baños debe ser mayor o igual a 1")
    @Max(value = 5, message = "El número de baños debe ser menor o igual a 5")
    private int numBaños;

    @Column(name = "tamaño")
    @DecimalMin(value = "0.0", message = "El tamaño debe ser mayor o igual a 0")
    @DecimalMax(value = "1000.0", message = "El tamaño debe ser menor o igual a 1000")
    private double tamaño;

    @Column(name = "garaje")
    private boolean garaje;

    @Column(name = "jardin")
    private boolean jardin;

    @Column(name = "piscina")
    private boolean piscina;

    @Column(name = "monto")
    @DecimalMin(value = "0.0", message = "El monto debe ser mayor o igual a 0")
    private double monto;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion = null;
    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion = null;

    @OneToOne
    @JoinColumn(name = "tipo_id", referencedColumnName = "tipo_id")
    private tipoPropiedad tipoPropi;

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public propiedadDescripcion() {
    }

    public Long getDescripcionId() {
        return descripcionId;
    }

    public void setDescripcionId(Long descripcionId) {
        this.descripcionId = descripcionId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public int getNumBaños() {
        return numBaños;
    }

    public void setNumBaños(int numBaños) {
        this.numBaños = numBaños;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public boolean isGaraje() {
        return garaje;
    }

    public void setGaraje(boolean garaje) {
        this.garaje = garaje;
    }

    public boolean isJardin() {
        return jardin;
    }

    public void setJardin(boolean jardin) {
        this.jardin = jardin;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public tipoPropiedad getTipoPropi() {
        return tipoPropi;
    }

    public void setTipoPropi(tipoPropiedad tipoPropi) {
        this.tipoPropi = tipoPropi;
    }

}
