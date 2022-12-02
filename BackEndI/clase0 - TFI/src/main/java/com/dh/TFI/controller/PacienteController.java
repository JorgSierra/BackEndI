package com.dh.TFI.controller;

import com.dh.TFI.entity.Paciente;
import com.dh.TFI.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteService pacienteService;
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @GetMapping
    public ResponseEntity<List<Paciente>> pacienteListar(){
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> pacienteBuscar(@PathVariable Long id){
        Optional<Paciente> result = pacienteService.buscarPacienteID(id);
        if (result.isPresent()){
            return ResponseEntity.ok(result.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Paciente> pacienteRegistrar(@RequestBody Paciente paciente){
        Paciente result = pacienteService.guardarPaciente(paciente);
        if (result.getId() != null){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping
    public ResponseEntity<String> pacienteActualizar(@RequestBody Paciente paciente){
        if (pacienteService.buscarPacienteID(paciente.getId()).isPresent()){
            pacienteService.modificarPaciente(paciente);
            return ResponseEntity.ok("Se actualizó el paciente id = " + paciente.getId());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> pacienteEliminar(@PathVariable Long id){
        if (pacienteService.buscarPacienteID(id).isPresent()){
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.ok("Se eliminó el paciente id = " + id);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
