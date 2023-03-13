package Classes;

import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
    private String nombre;
    private List<Pizza> pizzaList;

    public Pizzeria(String nombre) {
        this.nombre = nombre;
        this.pizzaList = new ArrayList<>();
    }

    public void agregarPizzas(Pizza pizza){
        this.pizzaList.add(pizza);
    }

    public List<String> mostrarPizzas(){
        List<String> menu = new ArrayList<>();
        for (Pizza pizza: pizzaList) {
           menu.add(pizza.toString());
        }
        return menu;
    }
}
