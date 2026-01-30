package com.homehorizon.bienesraices.model.propiedad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_propiedad")
public class tipoPropiedad {
    @Id
    @Column(name = "tipo_id")
    private Integer tipoId;
    @Column(name = "nombre_tipo")
    private String nombreTipo;

    public tipoPropiedad() {
    }

    public Integer getTipoId() {
        return tipoId;
    }

    public void setTipoId(Integer tipoId) {
        this.tipoId = tipoId;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

}
