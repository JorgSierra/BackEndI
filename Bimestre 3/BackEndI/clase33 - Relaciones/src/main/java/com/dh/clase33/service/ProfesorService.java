package com.dh.clase33.service;

import com.dh.clase33.entity.Profesor;
import com.dh.clase33.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {
    private ProfesorRepository profesorRepository;
    @Autowired
    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }
    public Profesor registrarProfesor(Profesor profesor){
        return profesorRepository.save(profesor);
    }
    public List<Profesor> listarProfesores(){
        return profesorRepository.findAll();
    }
}
