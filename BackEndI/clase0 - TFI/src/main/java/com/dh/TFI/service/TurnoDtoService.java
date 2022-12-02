package com.dh.TFI.service;


import com.dh.TFI.dto.TurnoDTO;
import com.dh.TFI.entity.Odontologo;
import com.dh.TFI.entity.Paciente;
import com.dh.TFI.entity.Turno;
import com.dh.TFI.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoDtoService {
    TurnoRepository turnoRepository;
    @Autowired
    public TurnoDtoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }
    public TurnoDTO guardarTurno (TurnoDTO dto){
        return turno2dto(turnoRepository.save(dto2turno(dto)));
    }
    public void modificarTurno (TurnoDTO dto){
        turnoRepository.save(dto2turno(dto));
    }
    public void eliminarTurno (Long id){

        turnoRepository.deleteById(id);
    }
    public Optional<TurnoDTO> buscarTurnoID (Long id){
        Optional<Turno> result = turnoRepository.findById(id);
        if (result.isPresent()){
            return Optional.of(turno2dto(result.get()));
        }
        else {
            return Optional.empty();
        }
    }
    public List<TurnoDTO> listarTurnos(){
        List<Turno> listResult =  turnoRepository.findAll();
        List<TurnoDTO> dtoListResutl = new ArrayList<>();
        for (Turno t:
             listResult) {
            dtoListResutl.add(turno2dto(t));
        }
        return dtoListResutl;
    }

    private TurnoDTO turno2dto (Turno turno){
        TurnoDTO result = new TurnoDTO();
        result.setId(turno.getId());
        result.setFecha(turno.getFecha());
        result.setPacienteId(turno.getPaciente().getId());
        result.setOdontologoId(turno.getOdontologo().getId());

        return result;
    }

    private Turno dto2turno (TurnoDTO dto){
        Turno result = new Turno();
        Paciente paciente = new Paciente();
        Odontologo odontologo = new Odontologo();

        paciente.setId(dto.getPacienteId());
        odontologo.setId(dto.getOdontologoId());

        result.setId(dto.getId());
        result.setFecha(dto.getFecha());
        result.setPaciente(paciente);
        result.setOdontologo(odontologo);

        return result;
    }
}

