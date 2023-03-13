import classes.Pizza;
import classes.PizzaCombinada;
import classes.PizzaSimple;
import classes.Pizzeria;
import factories.PizzaFactory;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        Pizzeria establecimiento = new Pizzeria("Pizza Loca");
        PizzaFactory fabrica = PizzaFactory.getInstance();

        Pizza muzzarella = fabrica.hacerPizza(PizzaFactory.PIZZA_SIMPLE,"muzzarella","Pizza que tiene mucho queso");
        ((PizzaSimple)muzzarella).setEsGrande(false);
        ((PizzaSimple)muzzarella).setPrecioBase(700);
        establecimiento.agregarPizza(muzzarella);

        Pizza especial = fabrica.hacerPizza(PizzaFactory.PIZZA_SIMPLE,"especial","Pizza que tiene de todo un poquito");
        ((PizzaSimple)especial).setEsGrande(false);
        ((PizzaSimple)especial).setPrecioBase(850);
        establecimiento.agregarPizza(especial);

        Pizza anana = fabrica.hacerPizza(PizzaFactory.PIZZA_SIMPLE,"ananá","Pizza que tiene mucho ananá");
        ((PizzaSimple)anana).setEsGrande(false);
        ((PizzaSimple)anana).setPrecioBase(950);
        establecimiento.agregarPizza(anana);

        Pizza combinadaLoca = fabrica.hacerPizza(PizzaFactory.PIZZA_COMBINADA, "Combinada Loca", "Dos mitades de pizza recomendadas");
        ((PizzaCombinada)combinadaLoca).agregarPizza(especial);
        ((PizzaCombinada)combinadaLoca).agregarPizza(anana);
        establecimiento.agregarPizza(combinadaLoca);

        List<String> menu = establecimiento.mostrarPizzas();

        for (String pizza:
             menu) {
            System.out.println(pizza);
        }

    }
}