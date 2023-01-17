package com.dh.clase23.controller;

import com.dh.clase23.model.Paciente;
import com.dh.clase23.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
    private PacienteService pacienteService;
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @GetMapping
    public String pacienteXEmail(Model model, @RequestParam("email") String email){
        Paciente result = pacienteService.buscarPacienteEmail(email);
        model.addAttribute("nombre", result.getNombre());
        model.addAttribute("apellido", result.getApellido());
        // Retorna un string que tiene que coincidir con el template
        return "busquedaPaciente";
    }
}
