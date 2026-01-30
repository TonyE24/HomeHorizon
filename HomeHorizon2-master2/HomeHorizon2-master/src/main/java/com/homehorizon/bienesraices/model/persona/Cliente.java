package com.homehorizon.bienesraices.model.persona;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.homehorizon.bienesraices.model.asignaciones.asignacion;
import com.homehorizon.bienesraices.model.asignaciones.historialTransacciones;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table (name="clientes")
public class Cliente {
    
    @Id
    @Column(name = "cliente_id", nullable = false)
    private String cliente_id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "correo")
    private String correo;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "fecha_registro")
    private Date fecha_registro;

    @ManyToOne(fetch = FetchType.LAZY)  
    @JoinColumn(name = "agente_asignado", referencedColumnName = "agente_id")
    private Agente agente;
    /*Aqui deberia ir la relacion
    @Column(name = "agente_asignado")
   private String agente_asignado;*/

    @Column(name = "estado")
    private Boolean estado; 
    @Column(name = "dui")
    private Integer dui;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Preferencia preferencia;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<asignacion> asignaciones = new ArrayList<>();
    
    @OneToMany (mappedBy="cliente" , cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private  List<historialTransacciones> historialTransacciones = new ArrayList<>();



    public Cliente() {
        prePersist();
    }

    @PrePersist
    public void prePersist() {
        if (this.cliente_id == null) {
            this.cliente_id = UUID.randomUUID().toString();
        }
    }

    

    public Preferencia getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Preferencia preferencia) {
        this.preferencia = preferencia;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }
    
    /*public String getAgente_asignado() {
        return agente_asignado;
    }
    public void setAgente_asignado(String agente_asignado) {
        this.agente_asignado = agente_asignado;
    } 
*/
    public Integer getDui() {
        return dui;
    }
    public void setDui(Integer dui) {
        this.dui = dui;
    }
    
    public Boolean isEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getCliente_id() {
        return cliente_id;
    }
    public void setCliente_id(String cliente_id) {
        this.cliente_id = cliente_id;
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
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Date getFecha_registro() {
        return fecha_registro;
    }
    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

}
