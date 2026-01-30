package com.homehorizon.bienesraices.controller;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.homehorizon.bienesraices.model.persona.Cliente;
import com.homehorizon.bienesraices.repository.IClientePreferenciaRepositorio;
import com.homehorizon.bienesraices.repository.IClienteRepositorio;

import jakarta.servlet.http.HttpSession;


public class clienteControllerTest {
@InjectMocks
    private clienteControlador clienteControlador;

    @Mock
    private IClienteRepositorio repoClientes;

    @Mock
    private IClientePreferenciaRepositorio repoPreferencia;

    @Mock
    private Model model;

    @Mock
    private HttpSession session;


    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarClientesSinFiltro() {
        when(session.getAttribute("usuario")).thenReturn("usuarioValido");

        Cliente cliente1 = new Cliente();
        cliente1.setCliente_id("1");
        cliente1.setNombre("Juan");
        
        Cliente cliente2 = new Cliente();
        cliente2.setCliente_id("2");
        cliente2.setNombre("Pedro");

        List<Cliente> clientes = Arrays.asList(cliente1, cliente2);

        when(repoClientes.findAll()).thenReturn(clientes);

        clienteControlador.listarClientes(null, model, session);

        System.out.println("Clientes obtenidos sin filtros: ");
        clientes.forEach(cliente -> System.out.println(cliente.getNombre()));
    }
}
