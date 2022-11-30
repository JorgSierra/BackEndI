package com.dh.clase23.controller;

import com.dh.clase23.model.Odontologo;
import com.dh.clase23.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdonologoController {
    /*
    private OdontologoService odontologoService;

    @Autowired
    public OdonologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }
    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Testing odontologo get!");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Odontologo>> odontologoListar() {
        return ResponseEntity.ok(odontologoService.listarOdontologos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> odontologoBuscar(@PathVariable Integer id) {
        Odontologo response = odontologoService.buscarOdontologoID(id);
        if (response != null){
            return ResponseEntity.ok(response);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Odontologo> odontologoRegistrar(@RequestBody Odontologo odontologo) {
        Odontologo response = odontologoService.guardarOdontologo(odontologo);
        if (response.getId() != null){
            return ResponseEntity.ok(response);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<String> odontologoActualizar(@RequestBody Odontologo odontologo) {
        if (odontologoService.buscarOdontologoID(odontologo.getId()) != null) {
            odontologoService.modificarOdontologo(odontologo);
            return ResponseEntity.ok("Se actualizó el odontologo id = " + odontologo.getId());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> odontologoEliminar(@PathVariable Integer id) {
        if (odontologoService.buscarOdontologoID(id) != null) {
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("Se eliminó el odontologo id = " + id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     */
}