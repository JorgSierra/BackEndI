import Classes.Pizza;
import Classes.PizzaCompuesta;
import Classes.PizzaSimple;
import Classes.Pizzeria;
import Factory.PizzaFactory;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Pizzeria pizzaLoca = new Pizzeria("PizzaLoca");

        Pizza muzzarella = PizzaFactory.getInstance().crearPizza(PizzaFactory.PIZZA_SIMPLE, "MUZZA","MUCHO QUESO!");
        Pizza especial = PizzaFactory.getInstance().crearPizza(PizzaFactory.PIZZA_SIMPLE, "LA ESPECIAL","SORPRENDENTE!");
        Pizza anana = PizzaFactory.getInstance().crearPizza(PizzaFactory.PIZZA_SIMPLE, "ANANA","INNOVADORA!");
        Pizza compuesta = PizzaFactory.getInstance().crearPizza(PizzaFactory.PIZZA_COMPUESTA, "COMBINADA LOCA", "DE TODO!");

        ((PizzaSimple)muzzarella).setGrande(false);
        ((PizzaSimple)muzzarella).setPrecioBase(700);

        ((PizzaSimple)especial).setGrande(false);
        ((PizzaSimple)especial).setPrecioBase(850);

        ((PizzaSimple)anana).setGrande(false);
        ((PizzaSimple)anana).setPrecioBase(950);

        ((PizzaCompuesta)compuesta).agregarPizzas(especial);
        ((PizzaCompuesta)compuesta).agregarPizzas(anana);

        pizzaLoca.agregarPizzas(muzzarella);
        pizzaLoca.agregarPizzas(anana);
        pizzaLoca.agregarPizzas(especial);
        pizzaLoca.agregarPizzas(compuesta);


        List<String> menus = pizzaLoca.mostrarPizzas();
        for (String menu: menus) {
            System.out.println(menu);
        }
    }

    public static void main(char args[]) {
        System.out.println("a");
    }
}