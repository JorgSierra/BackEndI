package classes;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
    private String nombre;
    private List<Pizza> pizzas;

    public Pizzeria(String nombre) {
        this.nombre = nombre;
        this.pizzas = new ArrayList<>();
    }

    public void  agregarPizza(Pizza pizza){
        this.pizzas.add(pizza);
    }

    public List<String> mostrarPizzas(){
        List<String> listadoPizzas = new ArrayList<>();
        for (Pizza pizza:
             pizzas) {
            listadoPizzas.add(pizza.toString());
        }
        return listadoPizzas;
    }
}
