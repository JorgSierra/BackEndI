package com.dh.clase23.controller;

import com.dh.clase23.model.Paciente;
import com.dh.clase23.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
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
    /*@GetMapping
    public String pacienteXEmail(Model model, @RequestParam("email") String email){
        Paciente result = pacienteService.buscarPacienteEmail(email);
        model.addAttribute("nombre", result.getNombre());
        model.addAttribute("apellido", result.getApellido());
        // Retorna un string que tiene que coincidir con el template
        return "busquedaPaciente";
    }*/
    @GetMapping
    public String test(){
        return "Testing paciente get!";
    }
    @GetMapping("/list")
    public List<Paciente> pacienteListar(){
        return pacienteService.listarPacientes();
    }
    @GetMapping("/{id}")
    public Paciente pacienteBuscar(@PathVariable Integer id){
        return pacienteService.buscarPacienteID(id);
    }
    @PostMapping
    public Paciente pacienteRegistrar(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }
    @PutMapping
    public String pacienteActualizar(@RequestBody Paciente paciente){
        Paciente result = pacienteService.buscarPacienteID(paciente.getID());
        if (result != null){
            pacienteService.modificarPaciente(paciente);
            return "Se actualizó el paciente id = " + paciente.getID();
        }
        else {
            return "El paciente con id = " + paciente.getID() + " no existe en DB";
        }
    }
    @DeleteMapping("/{id}")
    public String pacienteEliminar(@PathVariable Integer id){
        Paciente result = pacienteService.buscarPacienteID(id);
        if (result != null){
            pacienteService.eliminarPaciente(id);
            return "Se eliminó el paciente id = " + id;
        }
        else {
            return "El paciente con id = " + id + " no existe en DB";
        }
    }
}
