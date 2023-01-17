package com.dh.clase23.controller;

import com.dh.clase23.model.Odontologo;
import com.dh.clase23.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    /*@GetMapping
    public String odontologoXID(Model model, @RequestParam("id") Integer id){
        Odontologo result = odontologoService.buscarOdontologoID(id);
        model.addAttribute("matricula", result.getMatricula());
        return "busquedaOdontologo";
    }*/
    @GetMapping
    public String test() {
        return "Testing odontologo get!";
    }

    @GetMapping("/list")
    public List<Odontologo> odontologoListar() {
        return odontologoService.listarOdontologos();
    }

    @GetMapping("/{id}")
    public Odontologo odontologoBuscar(@PathVariable Integer id) {
        return odontologoService.buscarOdontologoID(id);
    }

    @PostMapping
    public Odontologo odontologoRegistrar(@RequestBody Odontologo odontologo) {
        return odontologoService.guardarOdontologo(odontologo);
    }

    @PutMapping
    public String odontologoActualizar(@RequestBody Odontologo odontologo) {
        Odontologo result = odontologoService.buscarOdontologoID(odontologo.getID());
        if (result != null) {
            odontologoService.modificarOdontologo(odontologo);
            return "Se actualizó el odontologo id = " + odontologo.getID();
        } else {
            return "El odontologo con id = " + odontologo.getID() + " no existe en DB";
        }
    }

    @DeleteMapping("/{id}")
    public String odontologoEliminar(@PathVariable Integer id) {
        Odontologo result = odontologoService.buscarOdontologoID(id);
        if (result != null) {
            odontologoService.eliminarOdontologo(id);
            return "Se eliminó el odontologo id = " + id;
        } else {
            return "El odontologo con id = " + id + " no existe en DB";
        }
    }
}

