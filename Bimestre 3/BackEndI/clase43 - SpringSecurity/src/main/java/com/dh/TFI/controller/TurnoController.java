package com.dh.TFI.controller;

import com.dh.TFI.entity.Turno;
import com.dh.TFI.exception.BadRequestException;
import com.dh.TFI.exception.ResourceNotFoundException;
import com.dh.TFI.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@RequestMapping("/noDTOturnos")
public class TurnoController {
    private TurnoService turnoService;
    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }
    @GetMapping
    public ResponseEntity<List<Turno>> turnoListar(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Turno> turnoBuscar(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(turnoService.buscarTurnoID(id));
    }
    @PostMapping
    public ResponseEntity<Turno> turnoRegistrar(@RequestBody Turno turno) throws ResourceNotFoundException, BadRequestException {
        return ResponseEntity.ok(turnoService.guardarTurno(turno));
    }
    @PutMapping
    public ResponseEntity<String> turnoActualizar(@RequestBody Turno turno) throws ResourceNotFoundException, BadRequestException{
        turnoService.modificarTurno(turno);
        return ResponseEntity.ok("Turno id = " + turno.getId() + " fue actualizado");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> turnoEliminar(@PathVariable Long id) throws ResourceNotFoundException{
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok("Turno id = " + id + " fue eliminado");
    }
}
