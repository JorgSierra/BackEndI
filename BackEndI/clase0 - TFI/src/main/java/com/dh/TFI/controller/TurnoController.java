package com.dh.TFI.controller;

import com.dh.TFI.entity.Turno;
import com.dh.TFI.service.OdontologoService;
import com.dh.TFI.service.PacienteService;
import com.dh.TFI.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// -------------------- IMPORTANTE ----------------------
// Se entiende que el DTO sería la salida de comunicación
// que se deja habilitada hacia el front para que no pueda
// tener interacción directa con las entity, pero voy a
// crearlos como services y controller diferentes para
// tener disponibles los dos métodos CON/SIN DTO

@RestController
@RequestMapping("/noDTOturnos")
public class TurnoController {
    private TurnoService turnoService;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;
    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }
    @GetMapping
    public ResponseEntity<List<Turno>> turnoListar(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Turno> turnoBuscar(@PathVariable Long id) {
        Optional<Turno> result = turnoService.buscarTurnoID(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Turno> turnoRegistrar(@RequestBody Turno turno){
        if (pacienteService.buscarPacienteID(turno.getPaciente().getId()).isPresent() &&
                odontologoService.buscarOdontologoID(turno.getOdontologo().getId()).isPresent()){
            return ResponseEntity.ok(turnoService.guardarTurno(turno));
        }
        else {
            return ResponseEntity.badRequest().build();
            // response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PutMapping
    public ResponseEntity<String> turnoActualizar(@RequestBody Turno turno){
        if (turnoService.buscarTurnoID(turno.getId()).isPresent()){
            if (pacienteService.buscarPacienteID(turno.getPaciente().getId()).isPresent() &&
                    odontologoService.buscarOdontologoID(turno.getOdontologo().getId()).isPresent()){
                turnoService.modificarTurno(turno);
                return ResponseEntity.ok("Turno id = " + turno.getId() + " fue actualizado");
            }
            else {
                return ResponseEntity.badRequest().body("Error al actualizar: El odontologo/paciente que se quiere asignar a este turno no se encuentra en DB");
                // response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
        else{
            return ResponseEntity.badRequest().body("Error al actualizar: El turno no se encuentra en DB");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> turnoEliminar(@PathVariable Long id){
        if (turnoService.buscarTurnoID(id).isPresent()){
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Turno id = " + id + " fue eliminado");
        }
        else {
            return ResponseEntity.notFound().build();
            // response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
