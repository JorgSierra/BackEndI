package classes;

import java.util.ArrayList;
import java.util.List;

public class PizzaCombinada implements Pizza{
    private String nombre, descripcion;
    private List<Pizza> combinacion;

    public PizzaCombinada(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.combinacion = new ArrayList<>();
    }

    @Override
    public double calcularPrecio() {
        double precio = 0;
        for (Pizza pizza:
             combinacion) {
            precio += pizza.calcularPrecio();
        }
        precio /= combinacion.size();
        return precio;
    }

    public void agregarPizza(Pizza pizza){
        this.combinacion.add(pizza);
    }

    @Override
    public String toString() {
        return "PizzaCombinada{" +
                "nombre='" + nombre + '\'' +
                ", precio='" + this.calcularPrecio() + '\'' +
                '}';
    }
}
