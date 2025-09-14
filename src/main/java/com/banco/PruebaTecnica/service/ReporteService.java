package com.banco.PruebaTecnica.service;

import com.banco.PruebaTecnica.dto.RespuestaWs;
import com.banco.PruebaTecnica.dto.aplicacion.CuentaDto;
import com.banco.PruebaTecnica.dto.aplicacion.MovimientoDto;
import com.banco.PruebaTecnica.entity.aplicacion.Movimiento;
import com.banco.PruebaTecnica.mappers.aplicacion.CuentaMapper;
import com.banco.PruebaTecnica.mappers.aplicacion.MovimientoMapper;
import com.banco.PruebaTecnica.repository.aplicacion.CuentaRepository;
import com.banco.PruebaTecnica.repository.aplicacion.MovimientoRepository;
import com.banco.PruebaTecnica.util.CatalogoMensaje;
import com.banco.PruebaTecnica.util.Constantes;
import com.banco.PruebaTecnica.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReporteService {
    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private MovimientoMapper movimientoMapper;
    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private CuentaMapper cuentaMapper;

    public RespuestaWs listMovimientosByCuentaAndDate(Long id, String strFechaDesde, String strFechaHasta) {
        try {
            CuentaDto cuenta = cuentaMapper.toDto(cuentaRepository.findByIdAndEstado(id, Constantes.ACTIVO));
            if(Utils.validarRangoFechas(strFechaDesde, strFechaHasta, "yyyy-MM-dd")) {
                return new RespuestaWs(CatalogoMensaje.E017.name(), CatalogoMensaje.E017.descripcion());
            }
            List<MovimientoDto> movimientoDtos = movimientoMapper.toDto(movimientoRepository.movimiemtosByDate(cuenta.getId(), strFechaDesde, strFechaHasta));
            if(movimientoDtos.isEmpty()) {
                return new RespuestaWs(CatalogoMensaje.E000.name(), CatalogoMensaje.E016.descripcion(),cuenta);
            }
            cuenta.setMovimientos(movimientoDtos);
            return new RespuestaWs(CatalogoMensaje.E000.name(), CatalogoMensaje.E000.descripcion(), cuenta);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E001.descripcion());
        }
    }
}
