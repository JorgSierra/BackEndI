package com.dh.clase34.repository;

import com.dh.clase34.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    //agregar un tecnico
    //agregar un jugador al tecnico

    //consultar todos los jugadores de un tecnico
    @Query("SELECT t FROM Tecnico t WHERE t.nombre = ?1")
    Optional<Tecnico> buscarTecnicoASDF(String nombre);

    List<Tecnico> findByEdadGreaterThan(Integer edad);
}
