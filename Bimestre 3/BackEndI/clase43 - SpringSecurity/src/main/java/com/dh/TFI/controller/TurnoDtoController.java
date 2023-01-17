package com.dh.TFI.controller;

import com.dh.TFI.dto.TurnoDTO;
import com.dh.TFI.exception.BadRequestException;
import com.dh.TFI.exception.ResourceNotFoundException;
import com.dh.TFI.service.OdontologoService;
import com.dh.TFI.service.PacienteService;
import com.dh.TFI.service.TurnoDtoService;
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
// *******************************************************
// ********** VISTAS SE COMUNICAN CON DTO ****************
// *******************************************************

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
    public ResponseEntity<TurnoDTO> turnoBuscar(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(turnoDtoService.buscarTurnoID(id));
    }
    @PostMapping
    public ResponseEntity<TurnoDTO> turnoRegistrar(@RequestBody TurnoDTO dto) throws ResourceNotFoundException, BadRequestException {
        return ResponseEntity.ok(turnoDtoService.guardarTurno(dto));
    }
    @PutMapping
    public ResponseEntity<String> turnoActualizar(@RequestBody TurnoDTO dto) throws ResourceNotFoundException, BadRequestException {
        turnoDtoService.modificarTurno(dto);
        return ResponseEntity.ok("Turno id = " + dto.getId() + " fue actualizado");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> turnoEliminar(@PathVariable Long id) throws ResourceNotFoundException{
        turnoDtoService.eliminarTurno(id);
        return ResponseEntity.ok("Turno id = " + id + " fue eliminado");
    }

}
