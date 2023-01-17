package com.dh.clase23.service;

import com.dh.clase23.entity.Paciente;
import com.dh.clase23.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    private PacienteRepository pacienteRepository;
    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    public Paciente guardarPaciente (Paciente paciente){
        return pacienteRepository.save(paciente);
    }
    public void modificarPaciente (Paciente paciente){
        pacienteRepository.save(paciente);
    }
    public void eliminarPaciente (Long id){
        pacienteRepository.deleteById(id);
    }
    public Optional<Paciente> buscarPacienteID (Long id){
        return pacienteRepository.findById(id);
    }
    public List<Paciente> listarPacientes(){
        return pacienteRepository.findAll();
    }
    public Optional<Paciente> buscarPacienteEmail (String email) { return  pacienteRepository.findByEmail(email);}
}
