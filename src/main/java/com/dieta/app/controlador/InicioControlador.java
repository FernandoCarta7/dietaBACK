package com.dieta.app.controlador;

import com.dieta.app.comparator.PacienteComparator;
import com.dieta.app.modelo.Paciente;
import com.dieta.app.servicio.PacienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//http://localhost:8080/dieta-app
@RestController
@RequestMapping("dieta-app")
@CrossOrigin(value = "http://localhost:4200")
public class InicioControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(InicioControlador.class);

    @Autowired
    private PacienteServicio pacienteServicio;
    //http://localhost:8080/dieta-app/pacientes

    //LISTAR PACIENTES
    @GetMapping("/pacientes")
    public List<Paciente> obtenerPacientes(){
        List<Paciente> pacientes = this.pacienteServicio.listarPacientes();
        PacienteComparator comparator = new PacienteComparator();

        pacientes.sort(comparator);
        logger.info("Pacientes obtenidos:");
        //pacientes.forEach((paciente -> logger.info(paciente.toString())));
        return pacientes;
    }
    //OBTENER PACIENTE POR ID
    @GetMapping("/paciente/{id}")
    public ResponseEntity<Paciente> obtenerPacienteId(@PathVariable int id){
        Paciente paciente = this.pacienteServicio.buscarPacientePorId(id);
        if (paciente != null){
            return ResponseEntity.ok(paciente);
        }else {
            logger.warn("No se econtró paciente");
            return null;
        }

    }

    //REGISTRAR PACIENTE
    @PostMapping("/pacientes/registrar")
    public Paciente agregagrPaciente(@RequestBody Paciente paciente){
        logger.info("Paciente agregado");

        return this.pacienteServicio.guardarPaciente(paciente);

    }

    //EDITAR PACIENTE
    @PutMapping("/pacientes/{id}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable int id,
                                                       @RequestBody Paciente pacienteRecibido){
        Paciente paciente = this.pacienteServicio.buscarPacientePorId(id);
        if (paciente != null){
            paciente.setAltura(pacienteRecibido.getAltura());
            paciente.setCelular(pacienteRecibido.getCelular());
            paciente.setCorreo(pacienteRecibido.getCorreo().toUpperCase());
            paciente.setEnfermedades(pacienteRecibido.getEnfermedades().toUpperCase());
            paciente.setFecha_nacimiento(pacienteRecibido.getFecha_nacimiento());
            paciente.setNivel_actividad(pacienteRecibido.getNivel_actividad().toUpperCase());
            paciente.setPeso(pacienteRecibido.getPeso());
            paciente.setPrimer_apellido(pacienteRecibido.getPrimer_apellido().toUpperCase());
            paciente.setPrimer_nombre(pacienteRecibido.getPrimer_nombre().toUpperCase());
            paciente.setSegundo_apellido(pacienteRecibido.getSegundo_apellido().toUpperCase());
            paciente.setSegundo_nombre(pacienteRecibido.getSegundo_nombre().toUpperCase());
            paciente.setGenero(pacienteRecibido.getGenero().toUpperCase());
        }else {
            logger.warn("No se encontró el paciente con el id: " + id);
        }
        this.pacienteServicio.guardarPaciente(paciente);
        return ResponseEntity.ok(paciente);
    }
}
