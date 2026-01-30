package com.homehorizon.bienesraices.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.homehorizon.bienesraices.model.propiedad.propiedad;
import com.homehorizon.bienesraices.repository.propiedadRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class propiedadServiceTest {

    @Mock
    private propiedadRepository propiedadRepository;

    @InjectMocks
    private propiedadService propiedadService;

    @Test
    public void testGuardarPropiedad() {
        // Preparación
        propiedad propiedad = new propiedad();
        propiedad.setPropiedadId("1");
        propiedad.setDireccion("Metapan");

        // Ejecución
        propiedad propiedadGuardada = propiedadService.guardarPropiedad(propiedad);

        // Verificación
        assertEquals(propiedad, propiedadGuardada);
        verify(propiedadRepository, times(1)).save(propiedad);
    }

    @Test
    public void testListarPropiedades() {
        // Preparación
        List<propiedad> propiedades = List.of(new propiedad(), new propiedad());

        // Configuración del mock
        when(propiedadRepository.findAll()).thenReturn(propiedades);

        // Ejecución
        List<propiedad> propiedadesListadas = propiedadService.listarPropiedades();

        // Verificación
        assertEquals(propiedades, propiedadesListadas);
        verify(propiedadRepository, times(1)).findAll();
    }

    @Test
    public void testObtenerPorId() {
        // Preparación
        propiedad propiedad = new propiedad();
        propiedad.setPropiedadId("1");
        propiedad.setDireccion("Metapan");

        // Configuración del mock
        when(propiedadRepository.findById("1")).thenReturn(Optional.of(propiedad));

        // Ejecución
        Optional<propiedad> propiedadObtenida = propiedadService.obtenerPorId("1");

        // Verificación
        assertTrue(propiedadObtenida.isPresent());
        assertEquals(propiedad, propiedadObtenida.get());
        verify(propiedadRepository, times(1)).findById("1");
    }

    @Test
    public void testBorrarPropiedad() {
        // Preparación
        String id = "1";

        // Configuración del mock
        when(propiedadRepository.existsById(id)).thenReturn(true);

        // Ejecución
        propiedadService.borrarPropiedad(id);

        // Verificación
        verify(propiedadRepository, times(1)).existsById(id);
        verify(propiedadRepository, times(1)).deleteById(id);
    }

    @Test
    public void testBorrarPropiedadNoExiste() {
        // Preparación
        String id = "1";

        // Configuración del mock
        when(propiedadRepository.existsById(id)).thenReturn(false);

        // Ejecución
        propiedadService.borrarPropiedad(id);

        // Verificación
        verify(propiedadRepository, times(1)).existsById(id);
        verify(propiedadRepository, never()).deleteById(id);
    }
}