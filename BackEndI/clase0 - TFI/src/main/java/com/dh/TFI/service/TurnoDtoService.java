package com.dh.TFI.service;


import com.dh.TFI.dto.TurnoDTO;
import com.dh.TFI.entity.Odontologo;
import com.dh.TFI.entity.Paciente;
import com.dh.TFI.entity.Turno;
import com.dh.TFI.exception.BadRequestException;
import com.dh.TFI.exception.ResourceNotFoundException;
import com.dh.TFI.repository.TurnoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoDtoService {
    TurnoRepository turnoRepository;
    OdontologoService odontologoService;
    PacienteService pacienteService;
    private final static Logger LOGGER = Logger.getLogger(TurnoDtoService.class);
    @Autowired
    public TurnoDtoService(TurnoRepository turnoRepository, OdontologoService odontologoService, PacienteService pacienteService) {
        this.turnoRepository = turnoRepository;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }
    public List<TurnoDTO> listarTurnos(){
        LOGGER.info("Obteniendo lista de turnos ...");
        List<Turno> listResult =  turnoRepository.findAll();
        List<TurnoDTO> dtoListResutl = new ArrayList<>();
        for (Turno t:
                listResult) {
            dtoListResutl.add(turno2dto(t));
        }
        return dtoListResutl;
    }
    public TurnoDTO buscarTurnoID (Long id) throws ResourceNotFoundException{
        LOGGER.info("Buscando turno por ID ...");
        Optional<Turno> result = turnoRepository.findById(id);
        if (result.isPresent()){
            LOGGER.info("Turno encontrado");
            return turno2dto(result.get());
        }
        else {
            throw new ResourceNotFoundException("[" + TurnoDtoService.class.getName() + "]" + " el turno buscado no existe en la DB");
        }
    }
    public TurnoDTO guardarTurno (TurnoDTO dto) throws BadRequestException, ResourceNotFoundException {
        LOGGER.info("Registrando turno ...");
        if (pacienteService.buscarPacienteID(dto.getPacienteId()) != null &&
                odontologoService.buscarOdontologoID(dto.getOdontologoId()) != null) {
            Turno result = turnoRepository.save(dto2turno(dto));
            if (result.getId() != null){
                LOGGER.info("Turno registrado");
                return turno2dto(result);
            }
            else{
                throw new BadRequestException("[" + TurnoDtoService.class.getName() + "]" + " el turno no pudo ser registrado");
            }
        }
        else{
            // Creo que nunca va a entrar aca por las excepciones de las comprobaciones del if
            throw new ResourceNotFoundException("[" + TurnoDtoService.class.getName() + "]" + " el odontologo/paciente que se quiere asignar a este turno no existe en la DB");
        }
    }
    public void modificarTurno (TurnoDTO dto) throws BadRequestException, ResourceNotFoundException{
        LOGGER.info("Actualizando turno ...");
        buscarTurnoID(dto.getId());
        LOGGER.info("Turno encontrado");
        if (pacienteService.buscarPacienteID(dto.getPacienteId()) != null &&
                odontologoService.buscarOdontologoID(dto.getOdontologoId()) != null){
            turnoRepository.save(dto2turno(dto));
            LOGGER.warn("Turno con ID: " + dto.getId() + " fue actualizado!");

        }
        else {
            // Creo que nunca va a entrar aca por las excepciones de las comprobaciones del if
            throw new BadRequestException ("[" + TurnoDtoService.class.getName() + "]" + " el odontologo/paciente que se quiere asignar a este turno no existe en la DB");
        }
    }
    public void eliminarTurno (Long id) throws ResourceNotFoundException{
        LOGGER.info("Eliminando turno ...");
        buscarTurnoID(id);
        LOGGER.info("Turno encontrado");
        turnoRepository.deleteById(id);
        LOGGER.warn("Turno con ID: " + id + " fue eliminado!");
    }

    private TurnoDTO turno2dto (Turno turno){
        TurnoDTO result = new TurnoDTO(turno.getId(), turno.getFecha(), turno.getPaciente().getId(), turno.getOdontologo().getId());

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

