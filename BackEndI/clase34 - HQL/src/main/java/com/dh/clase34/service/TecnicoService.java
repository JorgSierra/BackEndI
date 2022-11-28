package com.dh.clase34.service;

import com.dh.clase34.entity.Tecnico;
import com.dh.clase34.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    private TecnicoRepository tecnicoRepository;
    @Autowired
    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }
    public Optional<Tecnico> buscarTecnicoNombre(String nombre){
        return tecnicoRepository.buscarTecnicoASDF(nombre);
    }
    public Tecnico guardarTecnico(Tecnico tecnico){
        return tecnicoRepository.save(tecnico);
    }

    public List<Tecnico> buscarTecnicosMayoresQue(Integer edad){
        return tecnicoRepository.findByEdadGreaterThan(edad);
    }
}
