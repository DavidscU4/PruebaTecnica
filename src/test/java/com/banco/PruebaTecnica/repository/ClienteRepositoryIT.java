package com.banco.PruebaTecnica.repository;

import com.banco.PruebaTecnica.entity.Persona;
import com.banco.PruebaTecnica.entity.aplicacion.Cliente;
import com.banco.PruebaTecnica.repository.aplicacion.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import jakarta.persistence.EntityManager;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) // usa H2 del perfil test
class ClienteRepositoryIT {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EntityManager em;

    @Test
    void guardaYConsultaCliente_porPersonaId_funciona() {
        Persona persona = new Persona();
        em.persist(persona);
        Cliente cliente = new Cliente();
        cliente.setPersona(persona);
        cliente.setClave("1101122233");
        cliente.setEstado("ACTIVO");
        cliente.setFechaRegistro(new Date());
        em.persist(cliente);
        em.flush();
        em.clear();

        Cliente clienteBusqueda = clienteRepository.findByPersona_Id(persona.getId());
        assertNotNull(clienteBusqueda, "Debe encontrar el cliente");
        assertEquals("1101122233", clienteBusqueda.getClave());
        assertEquals("ACTIVO", clienteBusqueda.getEstado());
        assertNotNull(clienteBusqueda.getPersona());
        assertEquals(persona.getId(), clienteBusqueda.getPersona().getId());
    }
}
