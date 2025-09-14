package com.banco.PruebaTecnica.util;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

@Service
public class Utils {
    private static final Logger LOG = Logger.getLogger(Utils.class.getName());

    public static LocalDate convertirStringALocalDate(String fecha, String patron) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patron);
            return LocalDate.parse(fecha, formatter);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean validarRangoFechas(String strFechaDesde, String strFechaHasta, String patron) {
        LocalDate fechaDesde = convertirStringALocalDate(strFechaDesde, patron);
        LocalDate fechaHasta = convertirStringALocalDate(strFechaHasta, patron);
        return fechaHasta.isBefore(fechaDesde);
    }
}
