package com.banco.PruebaTecnica.repository.aplicacion;

import com.banco.PruebaTecnica.entity.aplicacion.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}
