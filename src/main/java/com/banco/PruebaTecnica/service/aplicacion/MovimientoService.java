package com.banco.PruebaTecnica.service.aplicacion;

import com.banco.PruebaTecnica.mappers.aplicacion.CuentaMapper;
import com.banco.PruebaTecnica.mappers.aplicacion.MovimientoMapper;
import com.banco.PruebaTecnica.repository.aplicacion.MovimientoRepository;
import com.banco.PruebaTecnica.resource.aplicacion.MovimientoResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoService;
    @Autowired
    private MovimientoMapper movimientoMapper;

}
