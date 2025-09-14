package com.banco.PruebaTecnica.resource.aplicacion;

import com.banco.PruebaTecnica.dto.aplicacion.CuentaDto;
import com.banco.PruebaTecnica.dto.aplicacion.MovimientoDto;
import com.banco.PruebaTecnica.service.aplicacion.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimientos")
public class MovimientoResource {

    @Autowired
    MovimientoService movimientoService;

    @PostMapping("/saveMovimiento")
    public ResponseEntity<?> realizarMovimiento(@RequestBody MovimientoDto movimientoDto) {
        try {
            return new ResponseEntity<>(movimientoService.realizarMovimiento(movimientoDto), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/reversarMovimiento")
    public ResponseEntity<?> reversarMovimiento(@RequestBody MovimientoDto movimientoDto) {
        try {
            return new ResponseEntity<>(movimientoService.reversarMovimiento(movimientoDto), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listMovimientos() {
        try {
            return new ResponseEntity<>(movimientoService.listMovimientos(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> listMovimientosByCuenta(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(movimientoService.listMovimientosByCuenta(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
