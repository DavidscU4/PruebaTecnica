package com.banco.PruebaTecnica.service.aplicacion;

import com.banco.PruebaTecnica.dto.RespuestaWs;
import com.banco.PruebaTecnica.dto.aplicacion.ClienteDto;
import com.banco.PruebaTecnica.dto.aplicacion.CuentaDto;
import com.banco.PruebaTecnica.entity.Persona;
import com.banco.PruebaTecnica.entity.aplicacion.Cliente;
import com.banco.PruebaTecnica.entity.aplicacion.Cuenta;
import com.banco.PruebaTecnica.mappers.PersonaMapper;
import com.banco.PruebaTecnica.mappers.aplicacion.CuentaMapper;
import com.banco.PruebaTecnica.repository.PersonaRepository;
import com.banco.PruebaTecnica.repository.aplicacion.ClienteRepository;
import com.banco.PruebaTecnica.repository.aplicacion.CuentaRepository;
import com.banco.PruebaTecnica.service.PersonaService;
import com.banco.PruebaTecnica.util.CatalogoMensaje;
import com.banco.PruebaTecnica.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private CuentaMapper cuentaMapper;
    @Autowired
    private ClienteRepository clienteRepository;

    public RespuestaWs save(CuentaDto cuentaDto) {
        try {
            Cliente cliente = clienteRepository.findByIdAndEstado(cuentaDto.getCliente(), Constantes.ACTIVO);
            if (cliente == null) {
                return new RespuestaWs(CatalogoMensaje.E004.name(), CatalogoMensaje.E004.descripcion());
            }
            Cuenta cuenta = cuentaRepository.findByNumeroCuentaAndEstado(cuentaDto.getNumeroCuenta(), Constantes.ACTIVO);
            if (cuenta != null) {
                return new RespuestaWs(CatalogoMensaje.E008.name(), CatalogoMensaje.E008.descripcion());
            }
            cuentaDto.setFechaRegistro(new Date());
            cuentaDto.setEstado(Constantes.ACTIVO);
            cuentaDto.setSaldo(cuentaDto.getSaldoInicial());
            cuentaDto.setId(cuentaRepository.save(cuentaMapper.toEntity(cuentaDto)).getId());
            return new RespuestaWs(CatalogoMensaje.E000.name(), CatalogoMensaje.E009.descripcion(), cuentaMapper.toEntity(cuentaDto));
        } catch (Exception e) {
            e.printStackTrace();
            return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E001.descripcion());
        }
    }

    public RespuestaWs update(CuentaDto cuentaDto) {
        try {
            Cuenta cuenta = cuentaRepository.findByIdAndEstado(cuentaDto.getId(), Constantes.ACTIVO);
            if (cuenta == null) {
                return new RespuestaWs(CatalogoMensaje.E010.name(), CatalogoMensaje.E010.descripcion());
            }
            if (cuentaDto.getNumeroCuenta() != null) {
                if (!cuenta.getNumeroCuenta().equals(cuentaDto.getNumeroCuenta())) {
                    return new RespuestaWs(CatalogoMensaje.E011.name(), CatalogoMensaje.E011.descripcion());
                }
            }
            if (cuentaDto.getTipoCuenta() != null) cuenta.setTipoCuenta(cuentaDto.getTipoCuenta());
            if (cuentaDto.getSaldoInicial() != null) {
                cuenta.setSaldoInicial(cuentaDto.getSaldoInicial());
                cuenta.setSaldo(cuentaDto.getSaldoInicial());
            }
            cuenta.setFechaModifica(new Date());
            cuentaRepository.save(cuenta);
            return new RespuestaWs(CatalogoMensaje.E000.name(), CatalogoMensaje.E006.descripcion());
        } catch (Exception e) {
            e.printStackTrace();
            return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E001.descripcion());
        }
    }

    public RespuestaWs delete(CuentaDto clienteDto) {
        try {
            Cuenta cuenta = cuentaRepository.findByIdAndEstado(clienteDto.getId(), Constantes.ACTIVO);
            if (cuenta == null) {
                return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E010.descripcion());
            }
            cuenta.setEstado(Constantes.INACTIVO);
            cuenta.setFechaModifica(new Date());
            cuentaRepository.save(cuenta);
            return new RespuestaWs(CatalogoMensaje.E000.name(), CatalogoMensaje.E006.descripcion());
        } catch (Exception e) {
            e.printStackTrace();
            return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E001.descripcion());
        }
    }

    public RespuestaWs list() {
        try {
            List<Cuenta> cuentas = cuentaRepository.findAllByEstado(Constantes.ACTIVO);
            return new RespuestaWs(CatalogoMensaje.E000.name(), CatalogoMensaje.E000.descripcion(), cuentas);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E001.descripcion());
        }
    }

    public RespuestaWs listByCliente(Long id) {
        try {
            List<Cuenta> cuentas = cuentaRepository.findAllByCliente_IdAndEstado(id, Constantes.ACTIVO);
            return new RespuestaWs(CatalogoMensaje.E000.name(), CatalogoMensaje.E000.descripcion(), cuentas);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E001.descripcion());
        }
    }
}
