package com.banco.PruebaTecnica.dto.aplicacion;

import java.util.Date;

public class ClienteDto {
    private Long id;
    private Long persona;
    private String clave;
    private String estado;
    private Date fechaRegistro;
    private Date fechaModifica;
    private String identificacion;
    private String nombres;
    private String telefono;
    private String direccion;
    private String genero;
    private Integer edad;
    public ClienteDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersona() {
        return persona;
    }

    public void setPersona(Long persona) {
        this.persona = persona;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    @Override
    public String toString() {
        return "ClienteDto{" +
                "id=" + id +
                ", persona=" + persona +
                ", clave='" + clave + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", fechaModifica=" + fechaModifica +
                ", identificacion='" + identificacion + '\'' +
                ", nombres='" + nombres + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", genero='" + genero + '\'' +
                ", edad=" + edad +
                '}';
    }
}
