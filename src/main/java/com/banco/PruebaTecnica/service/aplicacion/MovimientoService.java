package com.banco.PruebaTecnica.service.aplicacion;

import com.banco.PruebaTecnica.dto.RespuestaWs;
import com.banco.PruebaTecnica.dto.aplicacion.CuentaDto;
import com.banco.PruebaTecnica.dto.aplicacion.MovimientoDto;
import com.banco.PruebaTecnica.entity.aplicacion.Cuenta;
import com.banco.PruebaTecnica.entity.aplicacion.Movimiento;
import com.banco.PruebaTecnica.mappers.aplicacion.CuentaMapper;
import com.banco.PruebaTecnica.mappers.aplicacion.MovimientoMapper;
import com.banco.PruebaTecnica.repository.aplicacion.CuentaRepository;
import com.banco.PruebaTecnica.repository.aplicacion.MovimientoRepository;
import com.banco.PruebaTecnica.util.CatalogoMensaje;
import com.banco.PruebaTecnica.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private MovimientoMapper movimientoMapper;
    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private CuentaMapper cuentaMapper;

    public RespuestaWs realizarMovimiento(MovimientoDto movimientoDto) {
        try {
            Cuenta cuenta = cuentaRepository.findByIdAndEstado(movimientoDto.getCuenta(), Constantes.ACTIVO);
            if (cuenta == null) {
                return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E010.descripcion());
            }
            switch (movimientoDto.getTipoMovimiento()) {
                case Constantes.DEPOSITO:
                    cuenta.setSaldo(cuenta.getSaldo().add(movimientoDto.getValor()));
                    cuenta.setFechaModifica(new Date());
                    cuentaRepository.save(cuenta);
                    break;
                case Constantes.RETIRO:
                    if (movimientoDto.getValor().compareTo(cuenta.getSaldo()) > 0) {
                        return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E012.descripcion());
                    }
                    cuenta.setEstado(Constantes.ACTIVO);
                    cuenta.setSaldo(cuenta.getSaldo().subtract(movimientoDto.getValor()));
                    cuenta.setFechaModifica(new Date());
                    cuentaRepository.save(cuenta);
                    break;
                default:
                    return new RespuestaWs(CatalogoMensaje.E003.name(), CatalogoMensaje.E003.descripcion());
            }
            movimientoDto.setFechaMovimiento(new Date());
            movimientoDto.setSaldo(cuenta.getSaldo());
            movimientoDto.setDescripcion(movimientoDto.getTipoMovimiento() + " REALIZADO DE UN VALOR DE " + movimientoDto.getValor());
            movimientoDto.setFechaRegistro(new Date());
            movimientoDto.setId(movimientoRepository.save(movimientoMapper.toEntity(movimientoDto)).getId());
            return new RespuestaWs(CatalogoMensaje.E000.name(), CatalogoMensaje.E013.descripcion(), movimientoDto);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E001.descripcion());
        }
    }

    public RespuestaWs reversarMovimiento(MovimientoDto movimientoDto) {
        try {
            Movimiento ultimoMovimiento = movimientoRepository.findFirstByCuenta_IdAndEstadoOrderByIdDesc(movimientoDto.getCuenta(), Constantes.ACTIVO);
            if (!movimientoDto.getId().equals(ultimoMovimiento.getId())) {
                return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E014.descripcion());
            }
            Cuenta cuenta = ultimoMovimiento.getCuenta();
            switch (ultimoMovimiento.getTipoMovimiento()) {
                case Constantes.DEPOSITO:
                    cuenta.setSaldo(cuenta.getSaldo().subtract(ultimoMovimiento.getValor()));
                    cuenta.setFechaModifica(new Date());
                    cuentaRepository.save(cuenta);
                    break;
                case Constantes.RETIRO:
                    cuenta.setSaldo(cuenta.getSaldo().add(ultimoMovimiento.getValor()));
                    cuenta.setFechaModifica(new Date());
                    cuentaRepository.save(cuenta);
                    break;
                default:
                    return new RespuestaWs(CatalogoMensaje.E003.name(), CatalogoMensaje.E003.descripcion());
            }
            ultimoMovimiento.setEstado(Constantes.INACTIVO);
            ultimoMovimiento.setFechaModifica(new Date());
            movimientoRepository.save(ultimoMovimiento);
            return new RespuestaWs(CatalogoMensaje.E000.name(), CatalogoMensaje.E015.descripcion());
        } catch (Exception e) {
            e.printStackTrace();
            return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E001.descripcion());
        }
    }

    public RespuestaWs listMovimientos() {
        try {
            List<CuentaDto> cuentas = cuentaMapper.toDto(cuentaRepository.findAllByEstado(Constantes.ACTIVO));
            for (CuentaDto cuenta : cuentas) {
                cuenta.setMovimientos(movimientoMapper.toDto(movimientoRepository.findAllByCuenta_IdAndEstadoOrderByIdDesc(cuenta.getId(), Constantes.ACTIVO)));
            }
            return new RespuestaWs(CatalogoMensaje.E000.name(), CatalogoMensaje.E000.descripcion(), cuentas);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E001.descripcion());
        }
    }

    public RespuestaWs listMovimientosByCuenta(Long id) {
        try {
            CuentaDto cuenta = cuentaMapper.toDto(cuentaRepository.findByIdAndEstado(id, Constantes.ACTIVO));
            cuenta.setMovimientos(movimientoMapper.toDto(movimientoRepository.findAllByCuenta_IdAndEstadoOrderByIdDesc(cuenta.getId(), Constantes.ACTIVO)));
            return new RespuestaWs(CatalogoMensaje.E000.name(), CatalogoMensaje.E000.descripcion(), cuenta);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E001.descripcion());
        }
    }
}
