package com.dh.TFI.controller;

import com.dh.TFI.entity.Odontologo;
import com.dh.TFI.exception.BadRequestException;
import com.dh.TFI.exception.ResourceNotFoundException;
import com.dh.TFI.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdonologoController {
    private OdontologoService odontologoService;
    @Autowired
    public OdonologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }
    @GetMapping
    public ResponseEntity<List<Odontologo>> odontologoListar() {
        return ResponseEntity.ok(odontologoService.listarOdontologos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> odontologoBuscar(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(odontologoService.buscarOdontologoID(id));
    }
    @PostMapping
    public ResponseEntity<Odontologo> odontologoRegistrar(@RequestBody Odontologo odontologo) throws BadRequestException {
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }
    @PutMapping
    public ResponseEntity<String> odontologoActualizar(@RequestBody Odontologo odontologo) throws ResourceNotFoundException{
        odontologoService.modificarOdontologo(odontologo);
        return ResponseEntity.ok("Se actualizó el odontologo id = " + odontologo.getId());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> odontologoEliminar(@PathVariable Long id) throws ResourceNotFoundException{
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok("Se eliminó el odontologo id = " + id);
    }
}