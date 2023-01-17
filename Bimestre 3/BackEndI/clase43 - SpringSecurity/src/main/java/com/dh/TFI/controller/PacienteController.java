package com.dh.TFI.controller;

import com.dh.TFI.entity.Paciente;
import com.dh.TFI.exception.BadRequestException;
import com.dh.TFI.exception.ResourceNotFoundException;
import com.dh.TFI.service.PacienteService;
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
    @GetMapping
    public ResponseEntity<List<Paciente>> pacienteListar(){
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> pacienteBuscar(@PathVariable Long id) throws ResourceNotFoundException{
        return ResponseEntity.ok(pacienteService.buscarPacienteID(id));
    }
    @PostMapping
    public ResponseEntity<Paciente> pacienteRegistrar(@RequestBody Paciente paciente) throws BadRequestException {
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }
    @PutMapping
    public ResponseEntity<String> pacienteActualizar(@RequestBody Paciente paciente) throws ResourceNotFoundException{
        pacienteService.modificarPaciente(paciente);
        return ResponseEntity.ok("Se actualizó el paciente id = " + paciente.getId());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> pacienteEliminar(@PathVariable Long id) throws ResourceNotFoundException{
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok("Se eliminó el paciente id = " + id);
    }
}
