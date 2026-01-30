package com.homehorizon.bienesraices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homehorizon.bienesraices.model.persona.Cliente;
import com.homehorizon.bienesraices.repository.clienteRepositorioReporte;

@Service
public class clienteServicioReporte {
    @Autowired
    private clienteRepositorioReporte clienteRepositorio;
  

    public List<Cliente> listAll(String valor){
       if(valor !=null){
         return clienteRepositorio.findAll(valor);
       }
       return clienteRepositorio.findAll();
    }

    


}
