package com.banco.PruebaTecnica.service;

import com.banco.PruebaTecnica.entity.Persona;
import com.banco.PruebaTecnica.mappers.PersonaMapper;
import com.banco.PruebaTecnica.repository.PersonaRepository;
import com.banco.PruebaTecnica.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private PersonaMapper personaMapper;

    public Persona save(Persona persona) {
        try{
            persona.setEstado(Constantes.ACTIVO);
            persona.setFechaRegistro(new Date());
            return personaRepository.save(persona);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
