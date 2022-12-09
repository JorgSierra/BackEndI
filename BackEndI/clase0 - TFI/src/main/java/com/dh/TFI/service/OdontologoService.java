package com.dh.TFI.service;

import com.dh.TFI.entity.Odontologo;
import com.dh.TFI.exception.BadRequestException;
import com.dh.TFI.exception.ResourceNotFoundException;
import com.dh.TFI.repository.OdontologoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    private final OdontologoRepository odontologoRepository;
    private final static Logger LOGGER = Logger.getLogger(OdontologoService.class);
    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }
    public List<Odontologo> listarOdontologos(){
        LOGGER.info("Obteniendo lista de odontologos ...");
        return odontologoRepository.findAll();
    }
    public Odontologo buscarOdontologoID (Long id) throws ResourceNotFoundException{
        LOGGER.info("Buscando odontologo por ID ...");
        Optional<Odontologo> result = odontologoRepository.findById(id);
        if (result.isPresent()){
            LOGGER.info("Odontologo encontrado");
            return result.get();
        }
        else{
            throw new ResourceNotFoundException("[" + OdontologoService.class.getName() + "]" + " el odontologo no existe en la DB");
        }
    }
    public Odontologo guardarOdontologo (Odontologo odontologo) throws BadRequestException{
        LOGGER.info("Registrando odontologo ...");
        Odontologo result = odontologoRepository.save(odontologo);
        if (result.getId() != null){
            LOGGER.info("Odontologo registrado");
            return result;
        }
        else{
            throw new BadRequestException("[" + OdontologoService.class.getName() + "]" + " el odontologo no pudo ser registrado");
        }
    }
    public void modificarOdontologo (Odontologo odontologo) throws ResourceNotFoundException{
        LOGGER.info("Actualizando odontologo ...");
        buscarOdontologoID(odontologo.getId());
        LOGGER.info("Odontologo encontrado");
        odontologoRepository.save(odontologo);
        LOGGER.warn("Odontologo con ID: " + odontologo.getId() + " fue actualizado!");
    }
    public void eliminarOdontologo (Long id) throws ResourceNotFoundException{
        LOGGER.info("Eliminando odontologo ...");
        buscarOdontologoID(id);
        LOGGER.info("Odontologo encontrado");
        odontologoRepository.deleteById(id);
        LOGGER.warn("Odontologo con ID: " + id + " fue eliminado!");
    }
}
