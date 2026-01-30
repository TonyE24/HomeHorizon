package com.homehorizon.bienesraices.model.persona;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import com.homehorizon.bienesraices.model.asignaciones.asignacion;
import com.homehorizon.bienesraices.model.asignaciones.historialTransacciones;
import com.homehorizon.bienesraices.model.propiedad.zonas;
import com.homehorizon.bienesraices.validaciones.MiPattern;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

@Entity
@Table(name = "agentes")
public class Agente implements Serializable {
    @Id
    @Column(name = "agente_id")
    private String agente_id;
    @Column(name = "nombre")
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @MiPattern(regexp = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+$", message = "El nombre solo puede contener letras y espacios")
    private String nombre;

    @Column(name = "apellido")
    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    @MiPattern(regexp = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+$", message = "El apellido solo puede contener letras y espacios")
    private String apellido;

    @Column(name = "correo")
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    @MiPattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "El correo debe tener un formato válido")
    private String correo;

    @Column(name = "telefono")
    @NotBlank(message = "El teléfono es obligatorio")
    @MiPattern(regexp = "^[0-9]{0,8}$", message = "El teléfono debe contener entre 0 y 8 dígitos")
    private String telefono;

    @Column(name = "fecha_ingreso")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "La fecha de ingreso debe ser anterior a la fecha actual")
    private Date fecha_ingreso;
    @ManyToOne
    @JoinColumn(name = "zona_id")
    private zonas zona;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private usuario usuario;

    @OneToMany(mappedBy = "agente", cascade = CascadeType.ALL, orphanRemoval = true)
    List<historialTransacciones> historialTransacciones = new ArrayList<>();

    @OneToMany(mappedBy = "agente", cascade = CascadeType.ALL, orphanRemoval = true)
    List<asignacion> asignaciones = new ArrayList<>();

    @OneToMany(mappedBy = "agente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cliente> clientesAsignados = new ArrayList<>();

    public Agente() {
        prePersist();
    }

    @PrePersist
    public void prePersist() {
        if (this.agente_id == null) {
            this.agente_id = UUID.randomUUID().toString();
        }
    }

    public List<Cliente> getClientesAsignados() {
        return clientesAsignados;
    }

    public void setClientesAsignados(List<Cliente> clientesAsignados) {
        this.clientesAsignados = clientesAsignados;
    }

    public String getAgente_id() {
        return agente_id;
    }

    public void setAgente_id(String agente_id) {
        this.agente_id = agente_id;
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

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public zonas getZona() {
        return zona;
    }

    public void setZona(zonas zona) {
        this.zona = zona;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    public List<historialTransacciones> getHistorialTransacciones() {
        return historialTransacciones;
    }

    public void setHistorialTransacciones(List<historialTransacciones> historialTransacciones) {
        this.historialTransacciones = historialTransacciones;
    }

    public List<asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

}
