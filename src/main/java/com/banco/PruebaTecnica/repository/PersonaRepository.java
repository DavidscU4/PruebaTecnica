package com.banco.PruebaTecnica.repository;

import com.banco.PruebaTecnica.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    Persona findByIdAndEstado(Long id, String estado);

    Persona findByIdentificacionAndEstado(String identificacion, String estado);

}
