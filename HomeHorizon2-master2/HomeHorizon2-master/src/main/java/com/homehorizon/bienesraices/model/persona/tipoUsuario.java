package com.homehorizon.bienesraices.model.persona;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_usuario")
public class tipoUsuario implements Serializable {
    @Id
    @Column(name = "tipo_userId")
    private int tipoUserID;
    @Column(name = "tipo_usuario")
    private String tipoUsuario;

    public tipoUsuario() {
    }

    public tipoUsuario(int tipoUserID, String tipoUsuario) {
        this.tipoUserID = tipoUserID;
        this.tipoUsuario = tipoUsuario;
    }

    public int getTipoUserID() {
        return tipoUserID;
    }

    public void setTipoUserID(int tipoUserID) {
        this.tipoUserID = tipoUserID;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
