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
public class OdontologoController {
    OdontologoService odontologoService;
    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }
    @GetMapping
    public ResponseEntity<List<Odontologo>> odontologoListar() {
        return ResponseEntity.ok(odontologoService.listarOdontologos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> odontologoBuscar(@PathVariable Long id){
        Optional<Odontologo> result = odontologoService.buscarOdontologoID(id);
        if (result.isPresent()){
            return ResponseEntity.ok(result.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Odontologo> odontologoRegistrar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }
    @PutMapping
    public ResponseEntity<String> odontologoActualizar(@RequestBody Odontologo odontologo){
        Optional<Odontologo> buscado = odontologoService.buscarOdontologoID(odontologo.getId());
        if (buscado.isPresent()){
            odontologoService.modificarOdontologo(odontologo);
            return ResponseEntity.ok("El odontologo " + odontologo.getId() + " fue actualizado");
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> odontologoEliminar(@PathVariable Long id){
        Optional<Odontologo> result = odontologoService.buscarOdontologoID(id);
        if (result.isPresent()){
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("El odontologo " + id + " fue eliminado");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
