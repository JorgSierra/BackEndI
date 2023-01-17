package com.dh.TFI.service;

import com.dh.TFI.entity.Domicilio;
import com.dh.TFI.entity.Paciente;
import com.dh.TFI.exception.BadRequestException;
import com.dh.TFI.exception.ResourceNotFoundException;
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
    public void guardarPacienteTest() throws BadRequestException {
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
    public void bucarPacientePorIDTest() throws ResourceNotFoundException {
        Long ID = 1L;
        Paciente result = pacienteService.buscarPacienteID(ID);
        assertNotNull(result);
    }
    @Test
    @Order(3)
    public void guardarPacienteBaspiTest() throws BadRequestException{
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
    public void actualizarPacienteTest() throws ResourceNotFoundException{
        Long ID = 1L;
        Domicilio domicilio = new Domicilio(ID,"Calle Montañosa",5678,"Montañas","Bogota");
        LocalDate fecha = LocalDate.now();
        Paciente aActualizar = new Paciente(ID,"Laura","Morales","123456789", fecha,"laura@correo.com", domicilio);
        pacienteService.modificarPaciente(aActualizar);
        Paciente actualizado = pacienteService.buscarPacienteID(ID);

        assertEquals(ID, actualizado.getId());
        assertEquals("Laura", actualizado.getNombre());
        assertEquals("Morales", actualizado.getApellido());
        assertEquals(fecha, actualizado.getFechaIngreso());
        assertEquals(aActualizar.getDomicilio().getCalle(), actualizado.getDomicilio().getCalle());
        assertEquals(aActualizar.getDomicilio().getLocalidad(), actualizado.getDomicilio().getLocalidad());
    }
    @Test
    @Order(6)
    public void eliminarPacienteTest() throws ResourceNotFoundException{
        Long ID = 1L;
        pacienteService.eliminarPaciente(ID);
        Paciente result = pacienteService.buscarPacienteID(ID);
        assertNull(result);
    }
}