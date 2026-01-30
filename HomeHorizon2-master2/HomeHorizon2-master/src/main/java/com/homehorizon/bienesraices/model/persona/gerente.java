package com.homehorizon.bienesraices.model.persona;

import java.util.Date;

import com.homehorizon.bienesraices.model.propiedad.zonas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="gerentes")
public class gerente {
    @Id
   @Column(name="gerente_id")
    private String gerenteId;

    @OneToOne
    @JoinColumn(name="usuario_id",  referencedColumnName = "usuario_id")
    private usuario usuario;
   // private int usuarioId;

    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="correo")
    private String correo;
    @Column(name="telefono")
    private String telefono;
    @Column(name="fecha_ingreso")
    private Date fechaIngreso;
    //private int zonaId;
    @Column(name="estado")
    private boolean estado;

     @ManyToOne
    @JoinColumn(name = "zona_id")
    private zonas zona;


  


    public gerente() {
    }
    
    public String getGerenteId() {
        return gerenteId;
    }
    public void setGerenteId(String gerenteId) {
        this.gerenteId = gerenteId;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
   
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public zonas getZona() {
        return zona;
    }

    public void setZona(zonas zona) {
        this.zona = zona;
    }


    
}
