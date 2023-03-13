package com.company;

public class PacienteException extends Exception{
    public PacienteException() {
        super();
    }

    public PacienteException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Error: " + this.getClass().getName() + "Mensaje: " + this.getMessage();
    }
}
