package com.dh.clase23.controller;

import com.dh.clase23.model.Turno;
import com.dh.clase23.service.OdontologoService;
import com.dh.clase23.service.PacienteService;
import com.dh.clase23.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private TurnoService turnoService;
    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }
    @GetMapping
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Testing turnos get!");
    }
    @GetMapping("/list")
    public ResponseEntity<List<Turno>> turnoListar(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Turno> turnoBuscar(@PathVariable Integer id) {
        Turno response = turnoService.buscarTurnoID(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Turno> turnoRegistrar(@RequestBody Turno turno){
        PacienteService pacienteService = new PacienteService();
        OdontologoService odontologoService = new OdontologoService();
        if (pacienteService.buscarPacienteID(turno.getPaciente().getID()) != null && odontologoService.buscarOdontologoID(turno.getOdontologo().getID()) != null){
            return ResponseEntity.ok(turnoService.guardarTurno(turno));
        }
        else {
            return ResponseEntity.badRequest().build();
            // response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PutMapping
    public ResponseEntity<String> turnoActualizar(@RequestBody Turno turno){
        turnoEliminar(turno.getId());
        turnoRegistrar(turno);
        return ResponseEntity.ok("Turno id = " + turno.getId() + " fue actualizado");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> turnoEliminar(@PathVariable Integer id){
        if (turnoService.buscarTurnoID(id) != null){
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Turno id = " + id + " fue eliminado");
        }
        else {
            return ResponseEntity.notFound().build();
            // response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
