package com.banco.PruebaTecnica.mappers.aplicacion;

import com.banco.PruebaTecnica.dto.aplicacion.ClienteDto;
import com.banco.PruebaTecnica.entity.aplicacion.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "persona", source = "entity.persona.id")
    ClienteDto toDto(Cliente entity);

    @Mapping(source = "dto.persona", target = "persona.id")
    Cliente toEntity(ClienteDto dto);

    List<ClienteDto> toDto(List<Cliente> entity);

    List<Cliente> toEntity(List<ClienteDto> dto);
}
