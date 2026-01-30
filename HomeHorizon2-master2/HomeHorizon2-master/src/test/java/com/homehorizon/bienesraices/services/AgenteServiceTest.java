package com.homehorizon.bienesraices.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.homehorizon.bienesraices.model.persona.Agente;
import com.homehorizon.bienesraices.repository.AgenteRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AgenteServiceTest {

    @Mock
    private AgenteRepository agenteRepository;

    @InjectMocks
    private AgenteService agenteService;

    private Agente agente;

    @BeforeEach
    public void setup() {
        agente = new Agente();
        agente.setAgente_id("1");
        agente.setNombre("Juan");
        agente.setApellido("Pérez");
    }

    @Test
    public void testGuardarAgente() {
        when(agenteRepository.save(any(Agente.class))).thenReturn(agente);
        Agente agenteGuardado = agenteService.guardarAgente(agente);
        assertNotNull(agenteGuardado);
        assertEquals(agente.getAgente_id(), agenteGuardado.getAgente_id());
        assertEquals(agente.getNombre(), agenteGuardado.getNombre());
        assertEquals(agente.getApellido(), agenteGuardado.getApellido());
    }

    @Test
    public void testObtenerTodosLosAgentes() {
        List<Agente> agentes = List.of(agente);
        when(agenteRepository.findAll()).thenReturn(agentes);
        List<Agente> agentesObtenidos = agenteService.obtenerTodosLosAgentes();
        assertNotNull(agentesObtenidos);
        assertEquals(1, agentesObtenidos.size());
        assertEquals(agente, agentesObtenidos.get(0));
    }

    @Test
    public void testObtenerPorId() {
        when(agenteRepository.findById(anyString())).thenReturn(Optional.of(agente));
        Optional<Agente> agenteObtenido = agenteService.obtenerPorId("2");
        assertTrue(agenteObtenido.isPresent());
        assertEquals(agente, agenteObtenido.get());
    }

    @Test
    public void testBorrarAgente() {
        when(agenteRepository.existsById(anyString())).thenReturn(true);
        agenteService.borrarAgente("1");
        verify(agenteRepository, times(1)).deleteById("1");
    }

    @Test
    public void testObtenerPorUsuario() {
        when(agenteRepository.findByUsuarioId(anyInt())).thenReturn(agente);
        Agente agenteObtenido = agenteService.obtenerPorUsuario(1);
        assertNotNull(agenteObtenido);
        assertEquals(agente, agenteObtenido);
    }
}