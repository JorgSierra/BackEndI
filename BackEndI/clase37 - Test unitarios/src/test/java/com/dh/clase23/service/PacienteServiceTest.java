package com.dh.clase23.service;

import com.dh.clase23.entity.Domicilio;
import com.dh.clase23.entity.Paciente;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;
    @Test
    @Order(1)
    public void guardarPacienteTest(){
        Domicilio domicilio = new Domicilio("Calle la felicidad",1234,"Suba","Bogota");
        Paciente aGuardar = new Paciente("Jorge","Sierra","123456789", LocalDate.now(),"jorge@correo.com", domicilio);
        Paciente guardado = pacienteService.guardarPaciente(aGuardar);
        assertEquals(1L, guardado.getId());
        assertEquals(aGuardar.getDni(), guardado.getDni());
        assertEquals(aGuardar.getDomicilio().getCalle(), guardado.getDomicilio().getCalle());
        assertEquals(aGuardar.getDomicilio().getNumero(), guardado.getDomicilio().getNumero());
    }
    @Test
    @Order(2)
    public void bucarPacientePorIDTest(){
        Long ID = 1L;
        Optional<Paciente> result = pacienteService.buscarPacienteID(ID);
        assertNotNull(result.get());
    }
    @Test
    @Order(3)
    public void guardarPacienteBaspiTest(){
        Domicilio domicilio = new Domicilio("Calle A",548,"Salta Capital","Salta");
        Paciente aGuardar = new Paciente("Rodolfo","Baspineiro","548", LocalDate.now(),"baspi@correo.com", domicilio);
        Paciente guardado = pacienteService.guardarPaciente(aGuardar);
        assertEquals(2L, guardado.getId());
        assertEquals(aGuardar.getDni(), guardado.getDni());
        assertEquals(aGuardar.getDomicilio().getCalle(), guardado.getDomicilio().getCalle());
        assertEquals(aGuardar.getDomicilio().getNumero(), guardado.getDomicilio().getNumero());
    }
    @Test
    @Order(4)
    public void listarPacientesTest(){
        List<Paciente> result = pacienteService.listarPacientes();
        assertEquals(2, result.size());
    }
    @Test
    @Order(5)
    public void actualizarPacienteTest(){
        Long ID = 1L;
        Domicilio domicilio = new Domicilio(ID,"Calle Montañosa",5678,"Montañas","Bogota");
        LocalDate fecha = LocalDate.now();
        Paciente aActualizar = new Paciente(ID,"Laura","Morales","123456789", fecha,"laura@correo.com", domicilio);
        pacienteService.modificarPaciente(aActualizar);
        Optional<Paciente> actualizado = pacienteService.buscarPacienteID(ID);

        assertEquals(ID, actualizado.get().getId());
        assertEquals("Laura", actualizado.get().getNombre());
        assertEquals("Morales", actualizado.get().getApellido());
        assertEquals(fecha, actualizado.get().getFechaIngreso());
        assertEquals(aActualizar.getDomicilio().getCalle(), actualizado.get().getDomicilio().getCalle());
        assertEquals(aActualizar.getDomicilio().getLocalidad(), actualizado.get().getDomicilio().getLocalidad());
    }
    @Test
    @Order(6)
    public void eliminarPacienteTest(){
        Long ID = 1L;
        pacienteService.eliminarPaciente(ID);
        Optional<Paciente> result = pacienteService.buscarPacienteID(ID);
        assertFalse(result.isPresent());
    }
}