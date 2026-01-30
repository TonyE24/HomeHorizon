package com.homehorizon.bienesraices.model.asignaciones;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tipo_transaccion")
public class tipoTransaccion {
@Id
@Column(name="tipo_id")
private int tipoId;
@Column(name="tipo")
private String tipo;

@OneToMany(mappedBy = "tipoTransaccion")
private List< historialTransacciones> historialTransacciones ;


public tipoTransaccion() {
}



public tipoTransaccion(int tipoId, String tipo) {
    this.tipoId = tipoId;
    this.tipo = tipo;
}



public int getTipoId() {
    return tipoId;
}



public void setTipoId(int tipoId) {
    this.tipoId = tipoId;
}



public String getTipo() {
    return tipo;
}



public void setTipo(String tipo) {
    this.tipo = tipo;
}


}
