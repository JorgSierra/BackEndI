package com.company;

import java.util.Objects;

public class Empleado {
    private String nombre;
    private String legajo;
    protected  double sueldo;
    protected double descuentos;

    public Empleado(String nombre,String legajo)
    {
        this.nombre=nombre;
        this.legajo=legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }
    public double calcularSueldo()
    {
        return sueldo-descuentos;
    }
    public double calcularSueldo(double premio)
    {
        return sueldo+premio-descuentos;
    }

    @Override
    public String toString() {
        return  "Nombre= " + nombre + '\n' +
                "legajo= " + legajo + '\n' ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return this.getLegajo().equals(empleado.getLegajo());
    }

    @Override
    public int hashCode() {
        int hash=31;
        hash= hash* nombre.hashCode();
        hash= hash* legajo.hashCode();
        return hash;
    }
}
