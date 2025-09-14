package com.banco.PruebaTecnica.repository.aplicacion;

import com.banco.PruebaTecnica.entity.aplicacion.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    Cuenta findByNumeroCuentaAndEstado(String numeroCuenta, String estado);

    Cuenta findByIdAndEstado(Long id, String estado);

    List<Cuenta> findAllByEstado(String estado);

    List<Cuenta> findAllByCliente_IdAndEstado(Long id, String estado);

}
