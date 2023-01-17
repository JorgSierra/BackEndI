package com.dh.clase23.controller;

import com.dh.clase23.model.Odontologo;
import com.dh.clase23.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/odontologo")
public class OdonologoController {
    private OdontologoService odontologoService;
    @Autowired
    public OdonologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }
    @GetMapping
    public String odontologoXID(Model model, @RequestParam("id") Integer id){
        Odontologo result = odontologoService.buscarOdontologoID(id);
        model.addAttribute("matricula", result.getMatricula());
        return "busquedaOdontologo";
    }
}
