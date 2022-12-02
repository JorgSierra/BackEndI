package com.dh.TFI.controller;

import com.dh.TFI.entity.Odontologo;
import com.dh.TFI.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Odontologo> odontologoBuscar(@PathVariable Long id) {
        Optional<Odontologo> result = odontologoService.buscarOdontologoID(id);
        if (result.isPresent()){
            return ResponseEntity.ok(result.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Odontologo> odontologoRegistrar(@RequestBody Odontologo odontologo) {
        Odontologo result = odontologoService.guardarOdontologo(odontologo);
        if (result.getId() != null){
            return ResponseEntity.ok(result);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping
    public ResponseEntity<String> odontologoActualizar(@RequestBody Odontologo odontologo) {
        if (odontologoService.buscarOdontologoID(odontologo.getId()).isPresent()) {
            odontologoService.modificarOdontologo(odontologo);
            return ResponseEntity.ok("Se actualizó el odontologo id = " + odontologo.getId());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> odontologoEliminar(@PathVariable Long id) {
        if (odontologoService.buscarOdontologoID(id).isPresent()) {
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("Se eliminó el odontologo id = " + id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}