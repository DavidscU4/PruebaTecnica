package com.banco.PruebaTecnica.resource.aplicacion;

import com.banco.PruebaTecnica.dto.aplicacion.ClienteDto;
import com.banco.PruebaTecnica.service.aplicacion.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCliente(@RequestBody ClienteDto clienteDto) {
        try {
            return new ResponseEntity<>(clienteService.save(clienteDto), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{identificacion}")
    public ResponseEntity<?> editCliente(@PathVariable String identificacion, @RequestBody ClienteDto clienteDto) {
        try {
            return new ResponseEntity<>(clienteService.update(identificacion, clienteDto), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCliente(@RequestBody ClienteDto clienteDto) {
        try {
            return new ResponseEntity<>(clienteService.delete(clienteDto), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listClientes() {
        try {
            return new ResponseEntity<>(clienteService.list(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list/{identificacion}")
    public ResponseEntity<?> listClienteByIdentificacion(@PathVariable String identificacion) {
        try {
            return new ResponseEntity<>(clienteService.listByPersona(identificacion), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
