package com.dh.TFI.service;


import com.dh.TFI.entity.Turno;
import com.dh.TFI.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    TurnoRepository turnoRepository;
    @Autowired
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }
    public Turno guardarTurno (Turno turno){
        return turnoRepository.save(turno);
    }
    public void modificarTurno (Turno turno){
        turnoRepository.save(turno);
    }
    public void eliminarTurno (Long id){
        turnoRepository.deleteById(id);
    }
    public Optional<Turno> buscarTurnoID (Long id){
        return turnoRepository.findById(id);
    }
    public List<Turno> listarTurnos(){
        return turnoRepository.findAll();
    }
}
