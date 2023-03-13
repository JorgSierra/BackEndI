package com.company;

import java.time.*;

public class Main {

    public static void main(String[] args) {
        try{
            Paciente paciente=new Paciente("Juan","Perez","12345",LocalDate.now());
            paciente.darAlta(LocalDate.of(2022,8,1));
        }catch (PacienteException e){
            System.err.println(e.getMessage());
        }

    }
}
