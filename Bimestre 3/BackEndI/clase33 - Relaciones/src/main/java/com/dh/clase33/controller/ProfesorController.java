package com.dh.clase33.controller;

import com.dh.clase33.entity.Profesor;
import com.dh.clase33.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {
    private ProfesorService profesorService;
    @Autowired
    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }
    @GetMapping
    public ResponseEntity<List<Profesor>> listarProfesores(){
        return ResponseEntity.ok(profesorService.listarProfesores());
    }
}
