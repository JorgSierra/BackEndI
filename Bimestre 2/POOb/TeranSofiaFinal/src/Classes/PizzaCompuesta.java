package Classes;

import java.util.ArrayList;
import java.util.List;

public class PizzaCompuesta implements Pizza{
    private String nombre, descripcion;
    private List<Pizza> pizzaList;

    public PizzaCompuesta(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.pizzaList = new ArrayList<>();

    }

    public void agregarPizzas(Pizza pizza){
        this.pizzaList.add(pizza);
    }

    @Override
    public double calcularPrecio() {
        double precio = 0;
        double contadora = 0;
        for (Pizza pizza:pizzaList) {
            contadora ++;
            precio += pizza.calcularPrecio();
        }
        return precio/contadora;
    }

    @Override
    public String toString() {
        return "PizzaCompuesta{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", pizzaList=" + pizzaList +
                ",precio total: " + calcularPrecio() + '}';
    }
}
