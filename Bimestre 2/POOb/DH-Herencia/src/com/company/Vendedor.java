package com.company;

public class Vendedor extends Empleado{
    private int comision;
    private double importeVentas;


    public Vendedor(String nombre, String legajo) {
        super(nombre, legajo);
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public void setImporteVentas(double importeVentas) {
        this.importeVentas = importeVentas;
    }

    @Override
    public double calcularSueldo() {
        return sueldo + (importeVentas/100*comision)-descuentos;
        /* Otra forma
        return super.calcularSueldo() + importeVentas/100*comision;
         */
    }

    @Override
    public double calcularSueldo(double premio) {
        return sueldo+premio+(importeVentas/100*comision)-descuentos;
        /*Otra forma
            return super.calcularSueldo(premio)+importeVentas/100*comision;
         */
    }
    @Override
    public String toString() {
        return super.toString() +
                " Comision=" + comision + " % \n" +
                " Ventas=" + importeVentas;

    }


}
