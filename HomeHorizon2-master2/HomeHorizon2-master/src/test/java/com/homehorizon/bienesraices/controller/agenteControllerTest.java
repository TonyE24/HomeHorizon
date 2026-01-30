package com.homehorizon.bienesraices.controller;
import com.homehorizon.bienesraices.model.persona.Agente;
import com.homehorizon.bienesraices.services.AgenteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class agenteControllerTest {

    @Mock
    private AgenteService agenteService;

    @Mock
    private Model model;

    @Mock
    private HttpSession session;

    @InjectMocks
    private AgenteController agenteController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListaAgentes(){
        when(session.getAttribute("usuario")).thenReturn(new Object());
        
        List<Agente> agentes = new ArrayList<>();
        Agente agente1 = new Agente();
        agente1.setNombre("Agente 1");
        Agente agente2 = new Agente();
        agente2.setNombre("Agente 2");
        agentes.add(agente1);
        agentes.add(agente2);

        
        when(agenteService.obtenerTodosLosAgentes()).thenReturn(agentes);

        
        String resultado = agenteController.listaAgentes(model, session);

        
        verify(agenteService).obtenerTodosLosAgentes();

        
        verify(model).addAttribute("agentes", agentes);

        
        assertEquals("agente", resultado);

        
        System.out.println("Agentes obtenidos: ");
        for (Agente agente : agentes) {
            System.out.println("Nombre: " + agente.getNombre());
        }
        
    }

}
