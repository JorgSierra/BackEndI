package com.company;

import java.time.*;

public class Paciente {
    String nombre;
    String apellido;
    String dni;
    LocalDate fechaInternacion;
    LocalDate fechaAlta;


    Paciente(String nombre, String apellido, String dni, LocalDate fechaInternacion) throws PacienteException
    {   LocalDate hoy = LocalDate.now();
        this.nombre=nombre;
        this.apellido=apellido;
        this.dni = dni;
        fechaAlta=null;

        if (fechaInternacion.isBefore(hoy) || fechaInternacion.isEqual(hoy)) {
            this.fechaInternacion = fechaInternacion;
        }
        else {
            throw new PacienteException("La fecha de ingreso no es permitida");
        }
    }

    public LocalDate getFechaInternacion() {
        return fechaInternacion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void darAlta(LocalDate fechaAlta) throws PacienteException
    {
        if (fechaAlta.isAfter(fechaInternacion))
            System.out.println("Ok");
        else
            throw new PacienteException("No puede salir si no ha ingresado");
    }


    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaInternacion=" + fechaInternacion +
                ", fechaAlta=" + fechaAlta +
                '}';
    }
}
