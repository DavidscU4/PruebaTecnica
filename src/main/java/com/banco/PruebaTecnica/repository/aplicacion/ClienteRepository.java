package com.banco.PruebaTecnica.repository.aplicacion;

import com.banco.PruebaTecnica.entity.aplicacion.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
