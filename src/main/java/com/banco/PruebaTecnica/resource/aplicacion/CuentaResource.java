package com.banco.PruebaTecnica.resource.aplicacion;

import com.banco.PruebaTecnica.dto.aplicacion.ClienteDto;
import com.banco.PruebaTecnica.dto.aplicacion.CuentaDto;
import com.banco.PruebaTecnica.service.aplicacion.ClienteService;
import com.banco.PruebaTecnica.service.aplicacion.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
public class CuentaResource {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCuenta(@RequestBody CuentaDto cuentaDto) {
        try {
            return new ResponseEntity<>(cuentaService.save(cuentaDto), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editCuenta(@RequestBody CuentaDto cuentaDto) {
        try {
            return new ResponseEntity<>(cuentaService.update(cuentaDto), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCuenta(@RequestBody CuentaDto cuentaDto) {
        try {
            return new ResponseEntity<>(cuentaService.delete(cuentaDto), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listCuentas() {
        try {
            return new ResponseEntity<>(cuentaService.list(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> listCuentasByCliente(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(cuentaService.listByCliente(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
