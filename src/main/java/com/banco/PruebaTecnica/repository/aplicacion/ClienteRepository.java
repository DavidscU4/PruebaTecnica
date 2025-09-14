package com.banco.PruebaTecnica.repository.aplicacion;

import com.banco.PruebaTecnica.entity.aplicacion.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByPersona_Id(Long id);

    Cliente findByPersona_IdentificacionAndEstado(String identificacion, String estado);

    List<Cliente> findAllByEstado(String estado);

    Cliente findByIdAndEstado(Long id, String estado);
}
