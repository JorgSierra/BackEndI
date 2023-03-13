package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Vendedor nuevoVendedor= new Vendedor("Juan","1111");
        nuevoVendedor.setSueldo(45000);
        nuevoVendedor.setDescuentos(5000);
        nuevoVendedor.setComision(3);
        nuevoVendedor.setImporteVentas(300000);
        System.out.println(nuevoVendedor.toString());

        Empleado empleado1=new Empleado("Juan","1112");
        Empleado empleado2=new Empleado("Matias","1113");
        Empleado empleado3=new Empleado("Juan Carlos","1112");

        if (empleado1.equals(empleado2))
            System.out.println(empleado1.toString() + " es el mismo empleado que \n" +
                    empleado2.toString());
        else
            System.out.println(empleado1.toString() + " no es el mismo empleado que \n" +
                    empleado2.toString());

        if (empleado1.equals(empleado3))
            System.out.println(empleado1.toString() + " es el mismo empleado que \n" +
                    empleado3.toString());
        else
            System.out.println(empleado1.toString() + " no es el mismo empleado que \n " +
                    empleado3.toString());

    }
}
