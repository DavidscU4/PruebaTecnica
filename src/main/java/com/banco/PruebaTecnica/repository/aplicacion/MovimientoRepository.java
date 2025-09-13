package com.banco.PruebaTecnica.repository.aplicacion;

import com.banco.PruebaTecnica.entity.aplicacion.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
}
