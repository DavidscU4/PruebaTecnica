package com.banco.PruebaTecnica.entity;

import com.banco.PruebaTecnica.util.EsquemaConfig;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "persona", schema = EsquemaConfig.publico)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identificacion;
    private String nombres;
    private String telefono;
    private String direccion;
    private String genero;
    private Integer edad;
    private String estado;
    private Date fechaRegistro;
    private Date fechaModifica;

    public Persona() {
    }

    public Persona(Long id, String identificacion, String nombres, String telefono, String direccion, String genero, Integer edad) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.telefono = telefono;
        this.direccion = direccion;
        this.genero = genero;
        this.edad = edad;
    }

    public Persona(String identificacion, String nombres, String telefono, String direccion, String genero, Integer edad) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.telefono = telefono;
        this.direccion = direccion;
        this.genero = genero;
        this.edad = edad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return "PersonaMapper{" +
                "id=" + id +
                ", identificacion='" + identificacion + '\'' +
                ", nombres='" + nombres + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", genero='" + genero + '\'' +
                ", edad='" + edad + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", fechaModifica=" + fechaModifica +
                '}';
    }
}
