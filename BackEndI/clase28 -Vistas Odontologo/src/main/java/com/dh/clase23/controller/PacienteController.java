package com.dh.clase23.controller;

import com.dh.clase23.model.Paciente;
import com.dh.clase23.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteService pacienteService;
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    /*
    // Controller
    @GetMapping
    public String pacienteXEmail(Model model, @RequestParam("email") String email){
        Paciente result = pacienteService.buscarPacienteEmail(email);
        model.addAttribute("nombre", result.getNombre());
        model.addAttribute("apellido", result.getApellido());
        // Retorna un string que tiene que coincidir con el template
        return "busquedaPaciente";
    }*/
    @GetMapping
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Testing paciente get!");
    }
    @GetMapping("/list")
    public ResponseEntity<List<Paciente>> pacienteListar(){
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> pacienteBuscar(@PathVariable Integer id){
        Paciente response = pacienteService.buscarPacienteID(id);
        if (response != null){
            return ResponseEntity.ok(response);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Paciente> pacienteRegistrar(@RequestBody Paciente paciente){
        Paciente response = pacienteService.guardarPaciente(paciente);
        if (response.getID() != null){
            return ResponseEntity.ok(response);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping
    public ResponseEntity<String> pacienteActualizar(@RequestBody Paciente paciente){
        if (pacienteService.buscarPacienteID(paciente.getID()) != null){
            pacienteService.modificarPaciente(paciente);
            return ResponseEntity.ok("Se actualizó el paciente id = " + paciente.getID());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> pacienteEliminar(@PathVariable Integer id){
        if (pacienteService.buscarPacienteID(id) != null){
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.ok("Se eliminó el paciente id = " + id);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
