package com.banco.PruebaTecnica.dto.aplicacion;

import java.util.Date;

public class ClienteDto {
    private Long id;
    private Long persona;
    private String clave;
    private String estado;
    private Date fechaRegistro;
    private Date fechaModifica;

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

    @Override
    public String toString() {
        return "ClienteDto{" +
                "id=" + id +
                ", persona=" + persona +
                ", clave='" + clave + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", fechaModifica=" + fechaModifica +
                '}';
    }
}
