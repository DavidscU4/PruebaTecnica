package com.banco.PruebaTecnica.service.aplicacion;

import com.banco.PruebaTecnica.dto.RespuestaWs;
import com.banco.PruebaTecnica.dto.aplicacion.ClienteDto;
import com.banco.PruebaTecnica.entity.Persona;
import com.banco.PruebaTecnica.entity.aplicacion.Cliente;
import com.banco.PruebaTecnica.mappers.aplicacion.ClienteMapper;
import com.banco.PruebaTecnica.repository.PersonaRepository;
import com.banco.PruebaTecnica.repository.aplicacion.ClienteRepository;
import com.banco.PruebaTecnica.service.PersonaService;
import com.banco.PruebaTecnica.util.CatalogoMensaje;
import com.banco.PruebaTecnica.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private PersonaService personaService;

    public RespuestaWs save(ClienteDto clienteDto) {
        try {
            Persona persona = personaRepository.findByIdentificacionAndEstado(clienteDto.getIdentificacion(), Constantes.ACTIVO);
            Cliente cliente = new Cliente();
            if (persona == null) {
                persona = personaService.save(new Persona(clienteDto.getIdentificacion(), clienteDto.getNombres(), clienteDto.getTelefono(), clienteDto.getDireccion(), clienteDto.getGenero(), clienteDto.getEdad()));
            } else {
                if (clienteRepository.findByPersona_Id(persona.getId()) != null) {
                    return new RespuestaWs(CatalogoMensaje.E002.name(), CatalogoMensaje.E002.descripcion());
                }
            }
            clienteDto.setFechaRegistro(new Date());
            clienteDto.setEstado(Constantes.ACTIVO);
            clienteDto.setPersona(persona.getId());
            clienteDto.setId(clienteRepository.save(clienteMapper.toEntity(clienteDto)).getId());
            return new RespuestaWs(CatalogoMensaje.E000.name(), CatalogoMensaje.E003.descripcion(), clienteDto);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E001.descripcion());
        }
    }

    public RespuestaWs update(String identificacion, ClienteDto clienteDto) {
        try {
            if (!clienteDto.getIdentificacion().equals(identificacion)) {
                return new RespuestaWs(CatalogoMensaje.E002.name(), CatalogoMensaje.E007.descripcion());
            }
            Cliente cliente = clienteRepository.findByPersona_IdentificacionAndEstado(clienteDto.getIdentificacion(), Constantes.ACTIVO);
            if (cliente == null) {
                return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E004.descripcion());
            }
            Persona persona = cliente.getPersona();
            if (clienteDto.getNombres() != null) persona.setNombres(clienteDto.getNombres());
            if (clienteDto.getTelefono() != null) persona.setTelefono(clienteDto.getTelefono());
            if (clienteDto.getDireccion() != null) persona.setDireccion(clienteDto.getDireccion());
            if (clienteDto.getGenero() != null) persona.setGenero(clienteDto.getGenero());
            if (clienteDto.getEdad() != null) persona.setEdad(clienteDto.getEdad());
            persona.setFechaModifica(new Date());
            personaRepository.save(persona);

            if (clienteDto.getEstado() != null) cliente.setEstado(clienteDto.getEstado());
            if (clienteDto.getClave()  != null) cliente.setClave(clienteDto.getClave());
            cliente.setFechaModifica(new Date());
            clienteRepository.save(cliente);

            ClienteDto out = clienteMapper.toDto(cliente);
            return new RespuestaWs(CatalogoMensaje.E000.name(), CatalogoMensaje.E006.descripcion(), out);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E001.descripcion());
        }
    }

    public RespuestaWs delete(ClienteDto clienteDto) {
        try {
            Cliente cliente = clienteRepository.findByPersona_IdentificacionAndEstado(clienteDto.getIdentificacion(), Constantes.ACTIVO);
            if (cliente == null) {
                return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E004.descripcion());
            }
            cliente.setEstado(Constantes.INACTIVO);
            cliente.setFechaModifica(new Date());
            clienteRepository.save(cliente);
            return new RespuestaWs(CatalogoMensaje.E000.name(), CatalogoMensaje.E006.descripcion());
        } catch (Exception e) {
            e.printStackTrace();
            return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E001.descripcion());
        }
    }

    public RespuestaWs list() {
        try {
            List<Cliente> clientes = clienteRepository.findAllByEstado(Constantes.ACTIVO);
            if (clientes.isEmpty()) {
                return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E005.descripcion());
            }
            return new RespuestaWs(CatalogoMensaje.E000.name(), CatalogoMensaje.E000.descripcion(), clienteMapper.toDto(clientes));
        } catch (Exception e) {
            e.printStackTrace();
            return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E001.descripcion());
        }
    }

    public RespuestaWs listByPersona(String identificacion) {
        try {
            Cliente cliente = clienteRepository.findByPersona_IdentificacionAndEstado(identificacion, Constantes.ACTIVO);
            return new RespuestaWs(CatalogoMensaje.E000.name(), CatalogoMensaje.E000.descripcion(), clienteMapper.toDto(cliente));
        } catch (Exception e) {
            e.printStackTrace();
            return new RespuestaWs(CatalogoMensaje.E001.name(), CatalogoMensaje.E001.descripcion());
        }
    }
}
