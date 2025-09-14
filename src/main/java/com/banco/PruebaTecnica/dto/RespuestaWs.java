package com.banco.PruebaTecnica.dto;

import java.io.Serializable;

public class RespuestaWs implements Serializable {
    private String codigoError;
    private String mensaje;
    private Object data;

    public RespuestaWs() {
    }

    public RespuestaWs(Long id) {
        this.data = id;
    }

    public RespuestaWs(String codigoError, String mensaje) {
        this.codigoError = codigoError;
        this.mensaje = mensaje;
    }

    public RespuestaWs(Object data) {
        this.data = data;
    }

    public RespuestaWs(String codigoError, String mensaje, Object data) {
        this.codigoError = codigoError;
        this.mensaje = mensaje;
        this.data = data;
    }

    public String getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(String codigoError) {
        this.codigoError = codigoError;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
