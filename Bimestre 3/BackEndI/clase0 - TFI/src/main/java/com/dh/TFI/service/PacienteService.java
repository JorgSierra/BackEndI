package com.dh.TFI.service;

import com.dh.TFI.entity.Paciente;
import com.dh.TFI.exception.BadRequestException;
import com.dh.TFI.exception.ResourceNotFoundException;
import com.dh.TFI.repository.PacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;
    private final static Logger LOGGER = Logger.getLogger(PacienteService.class);
    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    public List<Paciente> listarPacientes(){
        LOGGER.info("Obteniendo lista de pacientes ...");
        return pacienteRepository.findAll();
    }
    public Paciente buscarPacienteID (Long id) throws ResourceNotFoundException{
        LOGGER.info("Buscando paciente por ID ...");
        Optional<Paciente> result = pacienteRepository.findById(id);
        if (result.isPresent()){
            LOGGER.info("Paciente encontrado");
            return result.get();
        }
        else{
            throw new ResourceNotFoundException("[" + PacienteService.class.getName() + "]" + " el paciente no existe en la DB");
        }
    }
    public Paciente guardarPaciente (Paciente paciente) throws BadRequestException{
        LOGGER.info("Registrando paciente ...");
        Paciente result = pacienteRepository.save(paciente);
        if (result.getId() != null){
            LOGGER.info("Paciente registrado");
            return result;
        }
        else{
            throw new BadRequestException("[" +PacienteService.class.getName() + "]" + " el paciente no pudo ser registrado");
        }
    }
    public void modificarPaciente (Paciente paciente) throws ResourceNotFoundException{
        LOGGER.info("Actualizando paciente ...");
        Paciente result = buscarPacienteID(paciente.getId());
        paciente.getDomicilio().setId(result.getDomicilio().getId());
        LOGGER.info("Paciente encontrado");
        pacienteRepository.save(paciente);
        LOGGER.warn("Paciente con ID: " + paciente.getId() + " fue actualizado!");
    }
    public void eliminarPaciente (Long id) throws ResourceNotFoundException{
        LOGGER.info("Eliminando paciente ...");
        buscarPacienteID(id);
        LOGGER.info("Paciente encontrado");
        pacienteRepository.deleteById(id);
        LOGGER.warn("Paciente con ID: " + id + " fue eliminado!");
    }
    public Optional<Paciente> buscarPacienteEmail (String email) { return  pacienteRepository.findByEmail(email);}
}
