package com.homehorizon.bienesraices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.homehorizon.bienesraices.model.persona.Cliente;

@Repository
public interface clienteRepositorioReporte extends JpaRepository<Cliente, String>{
@Query ("SELECT c FROM Cliente c WHERE " +
     "c.cliente_id LIKE %?1% OR " +  
     "CONCAT(c.nombre, ' ', c.apellido) LIKE %?1% OR "+
     "c.nombre LIKE %?1% OR "+ 
     "c.apellido LIKE %?1% OR " +
     "c.correo LIKE %?1% OR " +
     "c.telefono LIKE %?1% OR " +
     "c.direccion LIKE %?1% OR " +
     " STR(c.fecha_registro) LIKE %?1% OR"+ " STR(c.dui) LIKE %?1%" )
    List<Cliente> findAll(String valor);

    

}
