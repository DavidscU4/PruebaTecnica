package com.banco.PruebaTecnica.repository.aplicacion;

import com.banco.PruebaTecnica.entity.aplicacion.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    Movimiento findFirstByCuenta_IdAndEstadoOrderByIdDesc(Long id, String estado);

    List<Movimiento> findAllByCuenta_IdAndEstadoOrderByIdDesc(Long id, String estado);

    @Query(value = "SELECT mv FROM  Movimiento mv WHERE mv.cuenta.id = ?1 AND mv.estado = 'ACTIVO' AND mv.fechaMovimiento BETWEEN cast(?2 as date) AND cast(?3 as date)")
    List<Movimiento> movimiemtosByDate(Long id, String strFdesde, String strFhasta);
}
