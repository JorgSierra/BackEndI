package com.dh.clase31.service;

import com.dh.clase31.entity.Movimiento;
import com.dh.clase31.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovimientoService {
    MovimientoRepository movimientoRepository;
    @Autowired
    public MovimientoService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }
    public List<Movimiento> listMovimiento(){
        return movimientoRepository.findAll();
    }
    public Movimiento registrarMovimiento (Movimiento movimiento){
        return movimientoRepository.save(movimiento);
        // .save es usado tanto para registrar como para actualizar
    }
    public Optional<Movimiento> buscarMovimientoId (Integer id){
        return movimientoRepository.findById(id);
    }
    /* Alternativa 2 - No recomendada
    public Movimiento buscarMovimientoId (Integer id){
        return movimientoRepository.findById(id).get();
    }
    */

}
