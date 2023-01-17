package com.dh.TFI.service;


import com.dh.TFI.entity.Turno;
import com.dh.TFI.exception.BadRequestException;
import com.dh.TFI.exception.ResourceNotFoundException;
import com.dh.TFI.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// -------------------- IMPORTANTE ----------------------
// No se implementó logger en esta clase, ya que solo la
// dejé habilitada para poder comparar el funcionamiento de
// CON DTO vs. SIN DTO
@Service
public class TurnoService {
    TurnoRepository turnoRepository;
    OdontologoService odontologoService;
    PacienteService pacienteService;
    @Autowired
    public TurnoService(TurnoRepository turnoRepository, OdontologoService odontologoService, PacienteService pacienteService) {
        this.turnoRepository = turnoRepository;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }

    public List<Turno> listarTurnos(){
        return turnoRepository.findAll();
    }
    public Turno buscarTurnoID (Long id) throws ResourceNotFoundException{
        Optional<Turno> result = turnoRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException("El turno buscado no existe en la DB");
        }
    }
    public Turno guardarTurno (Turno turno) throws BadRequestException, ResourceNotFoundException {
        if (pacienteService.buscarPacienteID(turno.getPaciente().getId()) != null &&
                odontologoService.buscarOdontologoID(turno.getOdontologo().getId()) != null){
            Turno result = turnoRepository.save(turno);
            if (result.getId() != null){
                return result;
            }
            else{
                throw new BadRequestException("El turno no pudo ser registrado");
            }
        }
        else {
            throw new ResourceNotFoundException("El odontologo/paciente que se quiere asignar a este turno no existe en la DB");
        }
    }
    public void modificarTurno (Turno turno) throws BadRequestException, ResourceNotFoundException{
        buscarTurnoID(turno.getId());
        if (pacienteService.buscarPacienteID(turno.getPaciente().getId()) != null &&
            odontologoService.buscarOdontologoID(turno.getOdontologo().getId()) != null){
            turnoRepository.save(turno);
        }
        else {
            throw new BadRequestException ("El odontologo/paciente que se quiere asignar a este turno no existe en la DB");
        }
    }
    public void eliminarTurno (Long id) throws ResourceNotFoundException{
        buscarTurnoID(id);
        turnoRepository.deleteById(id);
    }
}
