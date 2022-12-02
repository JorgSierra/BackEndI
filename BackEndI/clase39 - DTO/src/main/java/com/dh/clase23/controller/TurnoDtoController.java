package com.dh.clase23.controller;

import com.dh.clase23.dto.TurnoDTO;
import com.dh.clase23.entity.Turno;
import com.dh.clase23.service.OdontologoService;
import com.dh.clase23.service.PacienteService;
import com.dh.clase23.service.TurnoDtoService;
import com.dh.clase23.service.TurnoService;
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
@RequestMapping("/turnos")
public class TurnoDtoController {
    private TurnoDtoService turnoDtoService;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;
    @Autowired
    public TurnoDtoController(TurnoDtoService turnoDtoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoDtoService = turnoDtoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public ResponseEntity<List<TurnoDTO>> turnoListar(){
        return ResponseEntity.ok(turnoDtoService.listarTurnos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> turnoBuscar(@PathVariable Long id) {
        Optional<TurnoDTO> result = turnoDtoService.buscarTurnoID(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<TurnoDTO> turnoRegistrar(@RequestBody TurnoDTO dto){
        if (pacienteService.buscarPacienteID(dto.getPacienteId()).isPresent() &&
                odontologoService.buscarOdontologoID(dto.getOdontologoId()).isPresent()){
            return ResponseEntity.ok(turnoDtoService.guardarTurno(dto));
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping
    public ResponseEntity<String> turnoActualizar(@RequestBody TurnoDTO dto){
        if (turnoDtoService.buscarTurnoID(dto.getId()).isPresent()){
            if (pacienteService.buscarPacienteID(dto.getPacienteId()).isPresent() &&
                    odontologoService.buscarOdontologoID(dto.getOdontologoId()).isPresent()){
                turnoDtoService.modificarTurno(dto);
                return ResponseEntity.ok("Turno id = " + dto.getId() + " fue actualizado");
            }
            else {
                return ResponseEntity.badRequest().body("Error al actualizar: El odontologo/paciente que se quiere asignar a este turno no se encuentra en DB");
            }
        }
        else{
            return ResponseEntity.badRequest().body("Error al actualizar: El turno no se encuentra en DB");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> turnoEliminar(@PathVariable Long id){
        if (turnoDtoService.buscarTurnoID(id).isPresent()){
            turnoDtoService.eliminarTurno(id);
            return ResponseEntity.ok("Turno id = " + id + " fue eliminado");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
