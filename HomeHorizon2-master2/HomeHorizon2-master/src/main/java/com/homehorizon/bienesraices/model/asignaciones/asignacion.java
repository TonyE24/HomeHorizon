package com.homehorizon.bienesraices.model.asignaciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.homehorizon.bienesraices.model.persona.Agente;
import com.homehorizon.bienesraices.model.persona.Cliente;
import com.homehorizon.bienesraices.model.propiedad.propiedad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="asignacion")
public class asignacion {

      @Id
    @Column(name = "asignacion_id", nullable = false)
    private String asignacionId;
   // private String agenteId;
   @ManyToOne
   @JoinColumn(name="agente_id" , nullable = false)
   private Agente agente;

    @ManyToOne 
    @JoinColumn(name="cliente_id" , nullable = false)
    private Cliente cliente;
    
    //private String propiedadId;

    @ManyToOne
    @JoinColumn(name="propiedad_id")
    private propiedad propiedad;

    
    //private String interaccionId;
    @ManyToOne
    @JoinColumn(name="interaccion_id")
    private interaccionClientes inteaccionClientes;

    @Column(name = "fecha_asignacion")
    private Date fechaAsignacion;

   @ManyToOne
   @JoinColumn(name="estado_asignacion")
   private estadoAsignacion estadoAsignacion;
   // private int estadoAsignacion;

   @OneToMany (mappedBy = "asignacion")
   private List<calendario> calendario = new ArrayList<>();

   @OneToMany (mappedBy = "asignacion")
   private List<estadoDecision> estadoDecisions = new ArrayList<>();





    
    public asignacion() {
    }


    public String getAsignacionId() {
        return asignacionId;
    }
    public void setAsignacionId(String asignacionId) {
        this.asignacionId = asignacionId;
    }
    public Agente getAgente() {
        return agente;
    }
    public void setAgente(Agente agente) {
        this.agente = agente;
    }
    public propiedad getPropiedad() {
        return propiedad;
    }


    public List<calendario> getCalendario() {
        return calendario;
    }


    public void setCalendario(List<calendario> calendario) {
        this.calendario = calendario;
    }


    public List<estadoDecision> getEstadoDecisions() {
        return estadoDecisions;
    }


    public void setEstadoDecisions(List<estadoDecision> estadoDecisions) {
        this.estadoDecisions = estadoDecisions;
    }


    public void setPropiedad(propiedad propiedad) {
        this.propiedad = propiedad;
    }


    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }


    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public estadoAsignacion getEstadoAsignacion() {
        return estadoAsignacion;
    }


    public void setEstadoAsignacion(estadoAsignacion estadoAsignacion) {
        this.estadoAsignacion = estadoAsignacion;
    }


    public interaccionClientes getInteaccionClientes() {
        return inteaccionClientes;
    }


    public void setInteaccionClientes(interaccionClientes inteaccionClientes) {
        this.inteaccionClientes = inteaccionClientes;
    }

   

}
