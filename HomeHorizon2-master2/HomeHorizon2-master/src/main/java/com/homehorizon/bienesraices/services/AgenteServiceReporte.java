package com.homehorizon.bienesraices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homehorizon.bienesraices.model.persona.Agente;
import com.homehorizon.bienesraices.repository.IAgenteReporteRepository;

@Service
public class AgenteServiceReporte {
    @Autowired
    private IAgenteReporteRepository agenteReporteRepository;



     public List<Agente> listAll(String valor){
       if(valor !=null){
         return agenteReporteRepository.buscarPorValor(valor);
       }
       return agenteReporteRepository.findAll();
    }

     
    


}
