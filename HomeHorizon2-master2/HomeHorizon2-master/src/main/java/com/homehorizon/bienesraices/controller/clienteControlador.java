package com.homehorizon.bienesraices.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.homehorizon.bienesraices.model.persona.Agente;
import com.homehorizon.bienesraices.model.persona.Cliente;
import com.homehorizon.bienesraices.model.persona.Preferencia;
import com.homehorizon.bienesraices.repository.IClientePreferenciaRepositorio;
import com.homehorizon.bienesraices.repository.IClienteRepositorio;
import com.homehorizon.bienesraices.services.AgenteService;

import jakarta.servlet.http.HttpSession;

@Controller
public class clienteControlador {

    private boolean verificarSesion(HttpSession session) {
        Object usuario = session.getAttribute("usuario");
        return usuario != null;
    }

    @Autowired
    private IClienteRepositorio repoClientes;

    @Autowired
    private IClientePreferenciaRepositorio repoClientePreferencia;

    @Autowired
    private AgenteService agenteService;

    @GetMapping("/Clientes")
    public String listarClientes(@RequestParam(value = "filtro", required = false) String filtro, Model model,
            HttpSession session) {
        if (!verificarSesion(session)) {
            return "redirect:/login";
        }

        try {
            List<Cliente> clientes;
            if (filtro != null && !filtro.isEmpty()) {
                clientes = repoClientes.findByNombreContainingIgnoreCase(filtro);
            } else {
                clientes = repoClientes.findAll();
            }
            model.addAttribute("clientes", clientes);
            return "cliente";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Error al listar clientes");
            return "error";
        }
    }

    @GetMapping("/crCliente")
    public String crearCliente(HttpSession session, Model model) {
        if (!verificarSesion(session)) {
            return "redirect:/login";
        }

        List<Agente> agentes = agenteService.obtenerTodosLosAgentes(); // Asegúrate de tener el repositorio de Agentes
        model.addAttribute("agentes", agentes);

        return "clientecreate.html";
    }

    @GetMapping("/mdCliente/{cliente_id}")
    public String modificarCliente(@PathVariable("cliente_id") String clienteId, Model model, HttpSession session) {
        if (!verificarSesion(session)) {
            return "redirect:/login";
        }

        List<Agente> agentes = agenteService.obtenerTodosLosAgentes(); // Asegúrate de tener el repositorio de Agentes
        model.addAttribute("agentes", agentes);

        try {
            Optional<Cliente> cliente = repoClientes.findById(clienteId);
            if (cliente.isPresent()) {
                Cliente cliente2 = cliente.get();
                Preferencia preferencia = cliente2.getPreferencia();
                model.addAttribute("cliente", cliente2);
                model.addAttribute("preferencia", preferencia);
                return "clientemodi.html";
            } else {
                model.addAttribute("error", "Cliente no encontrado");
                return "error";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el cliente");
            return "error";
        }
    }

    @PostMapping("/modificarCliente")
    public String modificarCliente(@RequestParam("preferencia_id") int preferencia_id,
            @RequestParam("cliente_id") String clienteId,
            @RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellido,
            @RequestParam("correo") String correo,
            @RequestParam("telefono") String telefono,
            @RequestParam("dui") int dui,
            @RequestParam("fecha_registro") Date fechaRegistro,
            @RequestParam("agente_asignado") String agenteAsignado, // recibimos el agente_id
            @RequestParam(value = "estado", required = false) Boolean estado,
            @RequestParam("tipo_propiedad") String tipoPropiedad,
            @RequestParam("presupuesto") BigDecimal presupuesto,
            @RequestParam("ubicacion") String ubicacion,
            @RequestParam("comentario") String comentario,
            Model model) {
        try {
            // Buscar el Agente usando el agente_id
            Optional<Agente> agenteOpt = agenteService.obtenerPorId(agenteAsignado);
            if (!agenteOpt.isPresent()) {
                model.addAttribute("error", "Agente no encontrado");
                return "error";
            }
            Agente agente = agenteOpt.get(); // Agente asignado al cliente

            // Buscar y actualizar el cliente
            Optional<Cliente> clienteOpt = repoClientes.findById(clienteId);
            if (clienteOpt.isPresent()) {
                Cliente cliente = clienteOpt.get();
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setCorreo(correo);
                cliente.setTelefono(telefono);
                cliente.setDui(dui);
                cliente.setFecha_registro(fechaRegistro);
                cliente.setAgente(agente); // Asignar el Agente al cliente
                cliente.setEstado(estado != null ? estado : cliente.isEstado()); // Mantener el estado si no se cambia

                repoClientes.save(cliente);

                // Actualizar la preferencia
                Preferencia preferencia = cliente.getPreferencia();
                preferencia.setPreferenciaId(preferencia_id);
                preferencia.setCliente(cliente);
                preferencia.setTipoPropiedad(tipoPropiedad);
                preferencia.setPresupuesto(presupuesto);
                preferencia.setUbicacion(ubicacion);
                preferencia.setComentario(comentario);

                repoClientePreferencia.save(preferencia);

                return "redirect:/Clientes";
            } else {
                model.addAttribute("error", "Cliente no encontrado");
                return "error";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Error al modificar cliente");
            return "error";
        }
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellido,
            @RequestParam("correo") String correo,
            @RequestParam("telefono") String telefono,
            @RequestParam("dui") int dui,
            @RequestParam("fecha_registro") Date fechaRegistro,
            @RequestParam("agente_asignado") String agenteAsignado, // recibimos el agente_id
            @RequestParam(value = "estado", required = true, defaultValue = "true") boolean estado,
            @RequestParam("tipo_propiedad") String tipoPropiedad,
            @RequestParam("presupuesto") BigDecimal presupuesto,
            @RequestParam("ubicacion") String ubicacion,
            @RequestParam("comentario") String comentario,
            Model model) {
        try {
            // Buscar el Agente usando el agente_id
            Optional<Agente> agenteOpt = agenteService.obtenerPorId(agenteAsignado);
            if (!agenteOpt.isPresent()) {
                model.addAttribute("error", "Agente no encontrado");
                return "error";
            }
            Agente agente = agenteOpt.get();

            // Crear y guardar el cliente
            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setCorreo(correo);
            cliente.setTelefono(telefono);
            cliente.setDui(dui);
            cliente.setFecha_registro(fechaRegistro);
            cliente.setAgente(agente); // Asignar el Agente al cliente
            cliente.setEstado(estado);

            repoClientes.save(cliente);

            // Crear y guardar la preferencia
            Preferencia preferencia = new Preferencia();
            preferencia.setCliente(cliente);
            preferencia.setTipoPropiedad(tipoPropiedad);
            preferencia.setPresupuesto(presupuesto);
            preferencia.setUbicacion(ubicacion);
            preferencia.setComentario(comentario);

            cliente.setPreferencia(preferencia);
            repoClientePreferencia.save(preferencia);

            return "redirect:/Clientes";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar cliente" + e.getMessage());
            return "error";
        }
    }

    /* */
    @GetMapping("Clientes/detalle/{cliente_id}")
    public String obtenerDetalleCliente(@PathVariable("cliente_id") String clienteId, Model model,
            HttpSession session) {
        if (!verificarSesion(session)) {
            return "redirect:/login";
        }

        try {
            Optional<Cliente> clienteOpt = repoClientes.findById(clienteId);
            if (clienteOpt.isPresent()) {
                Cliente cliente = clienteOpt.get();
                Preferencia preferencia = cliente.getPreferencia(); // Obtener preferencia del cliente

                model.addAttribute("cliente", cliente);
                model.addAttribute("preferencia", preferencia); // Agregar preferencia al modelo

                return "clienteDetalle";
            } else {
                model.addAttribute("error", "Cliente no encontrado");
                return "error";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Error al obtener detalle del cliente");
            return "error";
        }
    }

}
