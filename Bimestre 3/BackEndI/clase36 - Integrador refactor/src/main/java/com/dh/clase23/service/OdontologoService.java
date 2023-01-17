package com.dh.clase23.service;

import com.dh.clase23.model.Odontologo;
import com.dh.clase23.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    OdontologoRepository odontologoRepository;
    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }
    public Odontologo guardarOdontologo (Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }
    public void modificarOdontologo (Odontologo odontologo){
        odontologoRepository.save(odontologo);
    }
    public void eliminarOdontologo (Long id){
        odontologoRepository.deleteById(id);
    }
    public Optional<Odontologo> buscarOdontologoID (Long id){
        return odontologoRepository.findById(id);
    }
    public List<Odontologo> listarOdontologos(){
        return odontologoRepository.findAll();
    }
}
