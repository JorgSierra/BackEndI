package com.dh.clase23.controller;

import com.dh.clase23.model.Paciente;
import com.dh.clase23.model.Turno;
import com.dh.clase23.service.OdontologoService;
import com.dh.clase23.service.PacienteService;
import com.dh.clase23.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<Turno>> turnoListar(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }
    @PostMapping
    public ResponseEntity<Turno> turnoRegistrar(@RequestBody Turno turno){
        PacienteService pacienteService = new PacienteService();
        OdontologoService odontologoService = new OdontologoService();
        ResponseEntity<Turno> response;
        if (pacienteService.buscarPacienteID(turno.getPaciente().getID()) != null && odontologoService.buscarOdontologoID(turno.getOdontologo().getID()) != null){
            response = ResponseEntity.ok(turnoService.guardarTurno(turno));
        }
        else {
            response = ResponseEntity.badRequest().build();
            // response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }
}
