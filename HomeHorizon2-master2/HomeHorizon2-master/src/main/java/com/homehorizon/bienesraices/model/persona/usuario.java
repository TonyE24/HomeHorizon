package com.homehorizon.bienesraices.model.persona;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private int usuario_id;
    @Column(name = "usuario")
    @NotBlank(message = "El usuario es obligatorio")
    private String usuario;

    @Column(name = "contraseña")
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, max = 20, message = "La contraseña debe tener entre 8 y 20 caracteres")
    private String contraseña;

    @Column(name = "estado")
    private boolean estado;

    @OneToOne(mappedBy = "usuario")
    private gerente gerente;

    @OneToOne(mappedBy = "usuario")
    private Agente agente;

    @ManyToOne
    @JoinColumn(name = "tipo_userId", referencedColumnName = "tipo_userId")
    private tipoUsuario tipoUsuario;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public gerente getGerente() {
        return gerente;
    }

    public void setGerente(gerente gerente) {
        this.gerente = gerente;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public usuario() {

    }

    public tipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(tipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

}
