package com.banco.PruebaTecnica.util;

public enum CatalogoMensaje {

    E000("E000", "Ejecución satisfactoria", ""),
    E001("E001", "Error de ejecución", ""),
    E002("E002", "El cliente ya tiene cuenta", ""),
    E003("E003", "Cliente creado con exito", ""),
    E004("E004", "Cliente no encontrado", ""),
    E005("E005", "La identificación ya está registrada", ""),
    E006("E006", "Actualizado correctamente", ""),
    E007("E007", "No se puede cambiar la cédula del cliente", ""),
    E008("E008", "La cuenta ya se encuentra creada", ""),
    E009("E009", "Cuenta creada con exito", ""),
    E010("E010", "Cuenta no encontrada", ""),
    E011("E011", "No se puede cambiar el numero de la cuenta", ""),
    E012("E012", "Saldo no disponible", ""),
    E013("E013", "Transacción realizada con exito", ""),
    E014("E014", "Solo se puede reversar el ultimo movimiento", ""),
    E015("E015", "Movimiento reversado con exito", ""),
    E016("E016", "No hay ningun movimiento en el rango de fechas", ""),
    E017("E017", "Fecha hasta debe ser mayor a la fecha desde", ""),
    ;

    private final String codigo;
    private final String descripcion;
    private final String sugerencia;

    CatalogoMensaje(String codigo, String descripcion, String sugerencia) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.sugerencia = sugerencia;
    }

    public String codigo() {
        return codigo;
    }

    public String descripcion() {
        return descripcion;
    }

    public String sugerencia() {
        return sugerencia;
    }

    public static CatalogoMensaje of(String codigo) {
        for (CatalogoMensaje mode : CatalogoMensaje.values()) {
            if (mode.codigo().equals(codigo)) {
                return mode;
            }
        }
        return null;
    }
}
