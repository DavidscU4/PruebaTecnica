package com.banco.PruebaTecnica.domain;

import com.banco.PruebaTecnica.entity.Persona;
import com.banco.PruebaTecnica.entity.aplicacion.Cliente;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ClienteTest {

    @Test
    void debeCrearClienteYExponerEstadoConGetters() {
        Cliente c = new Cliente();
        c.setId(1L);
        c.setPersona(new Persona(3L));
        c.setClave("1101122233");

        assertEquals(1L, c.getId());
        assertEquals(3L, c.getPersona().getId());
        assertEquals("1101122233", c.getClave());
    }

    @Test
    void noDebePermitirClaveVacia_porBeanValidation() {
        Cliente c = new Cliente();
        c.setPersona(new Persona(3L));
        c.setClave("");

        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        var violations = validator.validate(c);

        assertTrue(
                violations.stream().anyMatch(v -> "clave".equals(v.getPropertyPath().toString())),
                "Se esperaba violación de validación en el campo 'clave'"
        );
    }

}
