package com.dh.TFI.service;

import com.dh.TFI.entity.Odontologo;
import com.dh.TFI.exception.BadRequestException;
import com.dh.TFI.exception.ResourceNotFoundException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;
    @Test
    @Order(1)
    public void guardarOdontologoTest() throws BadRequestException{
        Odontologo aGuardar = new Odontologo("MAT1234","Pedro","Muelas");
        Odontologo guardado = odontologoService.guardarOdontologo(aGuardar);
        assertEquals(1L, guardado.getId());
        assertEquals(aGuardar.getMatricula(), guardado.getMatricula());
        assertEquals(aGuardar.getNombre(), guardado.getNombre());
        assertEquals(aGuardar.getApellido(), guardado.getApellido());
    }
    @Test
    @Order(2)
    public void bucarOdontologoPorIDTest() throws ResourceNotFoundException {
        Long ID = 1L;
        Odontologo result = odontologoService.buscarOdontologoID(ID);
        assertNotNull(result);
    }
    @Test
    @Order(3)
    public void guardarOdontologoBaspiTest() throws BadRequestException{
        Odontologo aGuardar = new Odontologo("MAT1234","Pedro","Muelas");
        Odontologo guardado = odontologoService.guardarOdontologo(aGuardar);
        assertEquals(2L, guardado.getId());
        assertEquals(aGuardar.getMatricula(), guardado.getMatricula());
        assertEquals(aGuardar.getNombre(), guardado.getNombre());
        assertEquals(aGuardar.getApellido(), guardado.getApellido());
    }
    @Test
    @Order(4)
    public void listarOdontologoTest(){
        List<Odontologo> result = odontologoService.listarOdontologos();
        assertEquals(2, result.size());
    }
    @Test
    @Order(5)
    public void actualizarOdontologoTest() throws ResourceNotFoundException{
        Long ID = 1L;
        Odontologo aActualizar = new Odontologo(ID, "MAT567","Nubia","Muelitas");
        odontologoService.modificarOdontologo(aActualizar);
        Odontologo actualizado = odontologoService.buscarOdontologoID(ID);

        assertEquals(ID, actualizado.getId());
        assertEquals("MAT567", actualizado.getMatricula());
        assertEquals("Nubia", actualizado.getNombre());
        assertEquals("Muelitas", actualizado.getApellido());
    }
    @Test
    @Order(6)
    public void eliminarOdontologoTest() throws ResourceNotFoundException{
        Long ID = 1L;
        odontologoService.eliminarOdontologo(ID);
        Odontologo result = odontologoService.buscarOdontologoID(ID);
        assertNull(result);
    }
}