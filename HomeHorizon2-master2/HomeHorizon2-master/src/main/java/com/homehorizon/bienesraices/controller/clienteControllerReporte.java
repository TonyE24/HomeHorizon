package com.homehorizon.bienesraices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homehorizon.bienesraices.model.asignaciones.historialTransacciones;
import com.homehorizon.bienesraices.model.persona.Cliente;
import com.homehorizon.bienesraices.services.clienteServicioReporte;
import com.homehorizon.bienesraices.services.historialTransaccionesServiceReporte;

import jakarta.servlet.http.HttpSession;




@Controller
public class clienteControllerReporte {
  
@Autowired
    private clienteServicioReporte clienteServicio;
@Autowired
private historialTransaccionesServiceReporte historialTransacciones;

 private boolean verificarSesion(HttpSession session) {
        Object usuario = session.getAttribute("usuario");
        return usuario != null;
    }

    
    @GetMapping("/reporte")
    public String VerReporte(Model modelo, @RequestParam(value="palabra", required= false) String palabra,@RequestParam ( value="selectedClienteId", required= false) List<String> clienteId, HttpSession session) {
        if (!verificarSesion(session)) {
            return "redirect:/login";
        }

    
       List<Cliente> cliente = clienteServicio.listAll(palabra);
      modelo.addAttribute("listaClientes", cliente);

      return "reporte";


      }
      
    
    @GetMapping("/historial")
    public String cargarHistorial(@RequestParam("clienteId") String clienteId, Model model, HttpSession session) {
        if (!verificarSesion(session)) {
            return "redirect:/login";
        }


          
            List<historialTransacciones> historial = historialTransacciones.getHistorialForCliente(clienteId);
            if(historial.isEmpty()){
                System.out.println( "no hay transacciones");
                return "mensaje";
            }else{
                model.addAttribute("infoCliente", historial);
            model.addAttribute("clienteId", clienteId); 
        
          
            System.out.println("Received clienteId: " + clienteId);
            return "historial"; 
        

            }
    
       
            
    }
  
    
       
    
       
        
    }
         

     

    
      
      

    





