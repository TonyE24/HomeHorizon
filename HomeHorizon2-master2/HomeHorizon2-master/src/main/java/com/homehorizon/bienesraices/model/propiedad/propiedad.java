package com.homehorizon.bienesraices.model.propiedad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.homehorizon.bienesraices.model.asignaciones.asignacion;
import com.homehorizon.bienesraices.model.asignaciones.historialTransacciones;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "propiedades")
public class propiedad {
    @Id
    @Column(name = "propiedad_id")
    private String propiedadId;
    @Column(name = "direccion")
    @NotBlank(message = "La dirección es necesaria")
    @Size(min = 5, max = 255, message = "La dirección debe tener entre 5 y 255 caracteres")
    private String direccion;

    @Column(name = "ubicacion")
    @NotBlank(message = "La ubicación es obligatoria")
    @Size(min = 5, max = 255, message = "La ubicación debe tener entre 5 y 255 caracteres")
    private String ubicacion;

    @Column(name = "caracteristicas")
    @Size(max = 255, message = "Las características deben tener como máximo 255 caracteres")
    private String caracteristicas;

    @Column(name = "fecha_registro")
    @NotBlank(message = "La fecha de registro es obligatoria")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaRegistro;

    @Column(name = "documento")
    @NotBlank(message = "El documento es requerido")
    @Size(min = 5, max = 20, message = "El documento debe tener entre 5 y 20 caracteres")
    private String documento;

    @OneToMany(mappedBy = "propiedad")
    private List<historialTransacciones> historial_transacciones = new ArrayList<>();
    @OneToMany(mappedBy = "propiedad")
    private List<asignacion> asignaciones = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "descripcion_id", referencedColumnName = "descripcion_id")
    private propiedadDescripcion propiedadDescri;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private estadoPropiedad estadoPropiedad;

    @PrePersist
    public void prePersist() {
        if (this.propiedadId == null) {
            this.propiedadId = UUID.randomUUID().toString();
        }
    }

    public propiedad() {
        prePersist();
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getDocumento() {
        return documento;
    }

    public List<historialTransacciones> getHistorial_transacciones() {
        return historial_transacciones;
    }

    public void setHistorial_transacciones(List<historialTransacciones> historial_transacciones) {
        this.historial_transacciones = historial_transacciones;
    }

    public String getPropiedadId() {
        return propiedadId;
    }

    public void setPropiedadId(String propiedadId) {
        this.propiedadId = propiedadId;
    }

    public estadoPropiedad getEstadoPropiedad() {
        return estadoPropiedad;
    }

    public void setEstadoPropiedad(estadoPropiedad estadoPropiedad) {
        this.estadoPropiedad = estadoPropiedad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public List<asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

    public propiedadDescripcion getPropiedadDescri() {
        return propiedadDescri;
    }

    public void setPropiedadDescri(propiedadDescripcion propiedadDescri) {
        this.propiedadDescri = propiedadDescri;
    }

}
