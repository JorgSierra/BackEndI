package com.dh.entrenador.service;

import com.dh.entrenador.model.Entrenador;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EntrenadorServiceImpl implements EntrenadorService{

    @Override
    public List<Entrenador> listaEntrenadores() {
        return Arrays.asList(
                new Entrenador("Rodolfo"),
                new Entrenador("Ezequiel")
        );
    }
}
