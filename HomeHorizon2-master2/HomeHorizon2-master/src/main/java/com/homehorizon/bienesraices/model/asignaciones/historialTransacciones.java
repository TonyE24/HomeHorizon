package com.homehorizon.bienesraices.model.asignaciones;

import java.util.Date;

import com.homehorizon.bienesraices.model.persona.Agente;
import com.homehorizon.bienesraices.model.persona.Cliente;
import com.homehorizon.bienesraices.model.propiedad.propiedad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="historial_transacciones")
public class historialTransacciones {
    @Id
    @Column(name="transaccion_id")
    private String transaccionId;
    //private String propiedadId;
    //private String clienteId;
   // private String agenteId;\
   // private int tipoTransaccion;

    @Column(name="fecha_transaccion")
    private Date fechaTransaccion;
    @Column(name="precio_final")
    private double precioFinal;
    @Column(name="detalle")
    private String detalle;

    @ManyToOne
    @JoinColumn (name="cliente_id")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn (name="agente_id")
    private Agente agente;

    @ManyToOne
    @JoinColumn (name="propiedad_id")
    private propiedad propiedad;

    @ManyToOne
    @JoinColumn(name="tipo_transaccion")
    private tipoTransaccion tipoTransaccion;









    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }


    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }


    public propiedad getPropiedad() {
        return propiedad;
    }


    public void setPropiedad(propiedad propiedad) {
        this.propiedad = propiedad;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Agente getAgente() {
        return agente;
    }


    public void setAgente(Agente agente) {
        this.agente = agente;
    }


    // Constructor vacío
    public historialTransacciones() {}


    // Getters y Setters
    public String getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(String transaccionId) {
        this.transaccionId = transaccionId;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
