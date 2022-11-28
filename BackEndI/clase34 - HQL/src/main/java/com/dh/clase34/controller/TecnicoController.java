package com.dh.clase34.controller;

import com.dh.clase34.entity.Tecnico;
import com.dh.clase34.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {
    private TecnicoService tecnicoService;
    @Autowired
    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }
    @GetMapping("/{nombre}")
    public ResponseEntity<Tecnico> buscarTecnicoNombre(@PathVariable String nombre){
        Optional<Tecnico> result = tecnicoService.buscarTecnicoNombre(nombre);
        if (result.isPresent()){
            return ResponseEntity.ok(result.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("mayores/{edad}")
    public ResponseEntity<List<Tecnico>> buscarTecnicoEdadMayorA(@PathVariable Integer edad){
        return ResponseEntity.ok(tecnicoService.buscarTecnicosMayoresQue(edad));
    }
    @PostMapping
    public ResponseEntity<Tecnico> registrarTecnico(@RequestBody Tecnico tecnico){
        return ResponseEntity.ok(tecnicoService.guardarTecnico(tecnico));
    }

}
