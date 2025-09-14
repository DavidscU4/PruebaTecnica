package com.banco.PruebaTecnica.entity.aplicacion;

import com.banco.PruebaTecnica.entity.Persona;
import com.banco.PruebaTecnica.util.EsquemaConfig;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cliente", schema = EsquemaConfig.aplicacion)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "persona")
    private Persona persona;
    private String clave;
    private String estado;
    private Date fechaRegistro;
    private Date fechaModifica;

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
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
        return "Cliente{" +
                "id=" + id +
                ", persona=" + persona +
                ", clave='" + clave + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", fechaModifica=" + fechaModifica +
                '}';
    }
}