package com.banco.PruebaTecnica.mappers.aplicacion;

import com.banco.PruebaTecnica.dto.aplicacion.ClienteDto;
import com.banco.PruebaTecnica.dto.aplicacion.CuentaDto;
import com.banco.PruebaTecnica.entity.aplicacion.Cliente;
import com.banco.PruebaTecnica.entity.aplicacion.Cuenta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuentaMapper {

    @Mapping(target = "cliente", source = "entity.cliente.id")
    CuentaDto toDto(Cuenta entity);

    @Mapping(source = "dto.cliente", target = "cliente.id")
    Cuenta toEntity(CuentaDto dto);

    List<CuentaDto> toDto(List<Cuenta> entity);

    List<Cuenta> toEntity(List<CuentaDto> dto);
}
