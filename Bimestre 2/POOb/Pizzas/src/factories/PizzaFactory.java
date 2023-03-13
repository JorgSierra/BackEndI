package factories;

import classes.Pizza;
import classes.PizzaCombinada;
import classes.PizzaSimple;

public class PizzaFactory {
    private static PizzaFactory instance;
    public static final String PIZZA_SIMPLE = "PizzaSimple";
    public static final String PIZZA_COMBINADA = "PizzaCombinada";

    private PizzaFactory(){}

    public static PizzaFactory getInstance(){
        if (instance == null){
            instance = new PizzaFactory();
        }
        return instance;
    }

    public Pizza hacerPizza(String type, String nombre, String descripcion){
        switch (type){
            case PIZZA_SIMPLE:
                return new PizzaSimple(nombre,descripcion);
            case PIZZA_COMBINADA:
                return new PizzaCombinada(nombre, descripcion);
        }
        return null;
    }
}
