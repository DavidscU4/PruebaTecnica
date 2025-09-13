package com.banco.PruebaTecnica.mappers;

import com.banco.PruebaTecnica.dto.PersonaDto;
import com.banco.PruebaTecnica.entity.Persona;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    PersonaDto toDto(Persona entity);

    Persona toEntity(PersonaDto dto);

    List<PersonaDto> toDto(List<Persona> entity);

    List<Persona> toEntity(List<PersonaDto> dto);
}
