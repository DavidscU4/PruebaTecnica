package com.banco.PruebaTecnica.resource;

import com.banco.PruebaTecnica.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reportes")
public class ReporteResoruce {
    @Autowired
    private ReporteService reporteService;

    @GetMapping("/list/{id}/{strFdesde}/{strFhasta}")
    public ResponseEntity<?> listMovimientosByCuenta(@PathVariable Long id, @PathVariable String strFdesde, @PathVariable String strFhasta) {
        try {
            return new ResponseEntity<>(reporteService.listMovimientosByCuentaAndDate(id,strFdesde,strFhasta), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
