package com.banco.PruebaTecnica.mappers.aplicacion;

import com.banco.PruebaTecnica.dto.aplicacion.CuentaDto;
import com.banco.PruebaTecnica.dto.aplicacion.MovimientoDto;
import com.banco.PruebaTecnica.entity.aplicacion.Cuenta;
import com.banco.PruebaTecnica.entity.aplicacion.Movimiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {

    @Mapping(target = "cuenta", source = "entity.cuenta.id")
    MovimientoDto toDto(Movimiento entity);

    @Mapping(source = "dto.cuenta", target = "cuenta.id")
    Movimiento toEntity(MovimientoDto dto);

    List<MovimientoDto> toDto(List<Movimiento> entity);

    List<Movimiento> toEntity(List<MovimientoDto> dto);
}
