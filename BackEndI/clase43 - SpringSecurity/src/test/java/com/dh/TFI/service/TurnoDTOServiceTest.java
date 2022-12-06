package com.dh.TFI.service;

import com.dh.TFI.dto.TurnoDTO;
import com.dh.TFI.entity.Domicilio;
import com.dh.TFI.entity.Odontologo;
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

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class TurnoDTOServiceTest {
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private TurnoDtoService turnoDtoService;
    @Test
    @Order(1)
    public void guardarDependenciasTurnoDTOTest() throws BadRequestException{
        Domicilio domicilio = new Domicilio("Calle la felicidad",1234,"Suba","Bogota");
        Paciente paciente = new Paciente("Jorge","Sierra","123456789", LocalDate.now(),"jorge@correo.com", domicilio);
        Odontologo odontologo = new Odontologo("MAT1234","Pedro","Muelas");
        odontologoService.guardarOdontologo(odontologo);
        pacienteService.guardarPaciente(paciente);

        Domicilio dom = new Domicilio("Calle asdf",567,"Auburn","South");
        Paciente pac = new Paciente("Laura","Morales","98765", LocalDate.now(),"laura@correo.com", dom);
        Odontologo odo = new Odontologo("MAT0987","Pablo","Caries");
        odontologoService.guardarOdontologo(odo);
        pacienteService.guardarPaciente(pac);
    }

    @Test
    @Order(2)
    public void guardarTurnoDTOTest() throws BadRequestException, ResourceNotFoundException{
        TurnoDTO aGuardar = new TurnoDTO(LocalDate.now(),1L,1L);
        TurnoDTO guardado = turnoDtoService.guardarTurno(aGuardar);

        assertEquals(1L, guardado.getId());
        assertEquals(aGuardar.getFecha(), guardado.getFecha());
        assertEquals(aGuardar.getPacienteId(), guardado.getPacienteId());
        assertEquals(aGuardar.getOdontologoId(), guardado.getOdontologoId());
    }
    @Test
    @Order(3)
    public void bucarTurnoDTOPorIDTest() throws ResourceNotFoundException {
        Long ID = 1L;
        TurnoDTO result = turnoDtoService.buscarTurnoID(ID);
        assertNotNull(result);
    }
    @Test
    @Order(4)
    public void guardarTurnoDTOSecondTest() throws BadRequestException, ResourceNotFoundException{
        TurnoDTO aGuardar = new TurnoDTO(LocalDate.now(),2L,2L);
        TurnoDTO guardado = turnoDtoService.guardarTurno(aGuardar);

        assertEquals(2L, guardado.getId());
        assertEquals(aGuardar.getFecha(), guardado.getFecha());
        assertEquals(aGuardar.getPacienteId(), guardado.getPacienteId());
        assertEquals(aGuardar.getOdontologoId(), guardado.getOdontologoId());
    }
    @Test
    @Order(5)
    public void listarTurnoDTOTest(){
        List<TurnoDTO> result = turnoDtoService.listarTurnos();
        assertEquals(2, result.size());
    }
    @Test
    @Order(6)
    public void actualizarTurnoDTOTest() throws ResourceNotFoundException, BadRequestException{
        Long ID = 1L;
        LocalDate date = LocalDate.now();
        TurnoDTO aActualizar = new TurnoDTO(ID, LocalDate.now(),2L,2L);
        turnoDtoService.modificarTurno(aActualizar);
        TurnoDTO actualizado = turnoDtoService.buscarTurnoID(ID);

        assertEquals(ID, actualizado.getId());
        assertEquals(date, actualizado.getFecha());
        assertEquals(2L, actualizado.getOdontologoId());
        assertEquals(2L, actualizado.getPacienteId());
    }
    @Test
    @Order(7)
    public void eliminarTurnoDTOTest() throws ResourceNotFoundException{
        Long ID = 1L;
        turnoDtoService.eliminarTurno(ID);
        List<TurnoDTO> result = turnoDtoService.listarTurnos();
        assertEquals(1, result.size());
    }
}