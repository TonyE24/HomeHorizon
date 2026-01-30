package com.homehorizon.bienesraices.model.asignaciones;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="estado_decision")
public class estadoDecision {
    @Id
    @Column(name= "decision_id")
    private String decisionId;

    @ManyToOne
    @JoinColumn(name="asignacion")
    private asignacion asignacion;
    
   // private String asignacionId;
   @Column(name= "estado_decision")
    private String estadoDecision;
    @Column(name= "fecha_decision")
    private Date fechaDecision;
    @Column(name= "comentarios")
    private String comentarios;

 
    public estadoDecision() {
    }

  
    public String getDecisionId() {
        return decisionId;
    }

    public void setDecisionId(String decisionId) {
        this.decisionId = decisionId;
    }

    public String getEstadoDecision() {
        return estadoDecision;
    }

    public void setEstadoDecision(String estadoDecision) {
        this.estadoDecision = estadoDecision;
    }
    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }


    public asignacion getAsignacion() {
        return asignacion;
    }


    public void setAsignacion(asignacion asignacion) {
        this.asignacion = asignacion;
    }


    public Date getFechaDecision() {
        return fechaDecision;
    }


    public void setFechaDecision(Date fechaDecision) {
        this.fechaDecision = fechaDecision;
    }


  



}
