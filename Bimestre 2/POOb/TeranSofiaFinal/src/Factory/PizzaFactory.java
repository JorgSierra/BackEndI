package Factory;

import Classes.Pizza;
import Classes.PizzaCompuesta;
import Classes.PizzaSimple;

public class PizzaFactory {

    private static PizzaFactory instance;

    public static final String PIZZA_SIMPLE = "Pizza simple";
    public static final String PIZZA_COMPUESTA = "Pizza compuesta";

    public PizzaFactory(){}

    public static PizzaFactory getInstance() {
        if (instance == null){
            instance = new PizzaFactory();
        }
        return instance;
    }

    public Pizza crearPizza (String codigo, String nombre , String descripcion){
        switch (codigo){
            case PIZZA_SIMPLE:
                return new PizzaSimple(nombre, descripcion);
            case PIZZA_COMPUESTA:
                return new PizzaCompuesta(nombre, descripcion);
        }
        return null;
    }
}
