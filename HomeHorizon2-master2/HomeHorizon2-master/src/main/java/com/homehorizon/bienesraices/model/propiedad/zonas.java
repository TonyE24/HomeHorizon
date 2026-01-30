package com.homehorizon.bienesraices.model.propiedad;

import java.io.Serializable;
import java.util.List;

import com.homehorizon.bienesraices.model.persona.gerente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "zonas")
public class zonas implements Serializable {
    @Id
    @Column(name = "zona_id")
    private int zonaID;
    @Column(name = "zona")
    private String zona;

    @OneToMany(mappedBy = "zona")
    private List<gerente> gerentes;

    public zonas(int zonaID, String zona) {
        this.zonaID = zonaID;
        this.zona = zona;
    }

    public zonas() {
    }

    public int getZonaID() {
        return zonaID;
    }

    public void setZonaID(int zonaID) {
        this.zonaID = zonaID;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

}
