package com.homehorizon.bienesraices.model.persona;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente_preferencia")
public class Preferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="preferencia_id")
    private Integer preferenciaId;

    @OneToOne
    @JoinColumn(name="cliente_id")
    Cliente cliente;
    

    

    @Column(name = "tipo_propiedad")
    private String tipoPropiedad;

    @Column(name = "presupuesto")
    private BigDecimal presupuesto;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "comentario")
    private String comentario;

   

    public String getTipoPropiedad() {
        return tipoPropiedad;
    }

    public void setTipoPropiedad(String tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigDecimal presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getPreferenciaId() {
        return preferenciaId;
    }

    public void setPreferenciaId(Integer preferenciaId) {
        this.preferenciaId = preferenciaId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}
