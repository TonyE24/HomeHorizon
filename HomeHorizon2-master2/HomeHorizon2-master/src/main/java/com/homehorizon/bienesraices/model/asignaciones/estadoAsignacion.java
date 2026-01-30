package com.homehorizon.bienesraices.model.asignaciones;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="estado_asignacion")
public class estadoAsignacion {
    @Id
@Column (name="estado_id")
private int estadoID;
@OneToMany(mappedBy="estadoAsignacion")
List<asignacion> asignacion = new ArrayList<>();

//private String estado;


public estadoAsignacion() {
}



public int getEstadoID() {
    return estadoID;
}
public void setEstadoID(int estadoID) {
    this.estadoID = estadoID;
}



public List<asignacion> getAsignacion() {
    return asignacion;
}



public void setAsignacion(List<asignacion> asignacion) {
    this.asignacion = asignacion;
}



}
