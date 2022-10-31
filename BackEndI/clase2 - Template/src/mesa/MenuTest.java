package mesa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MenuTest {
    @Test
    public void pruebaMenuClasico(){
        //dado
        Menu menu1 = new MenuClasico(1000.0);
        String rtaEsperada = "El total de su pedido es: 1000.0";

        //cuando
        String rta =  menu1.prepararMenu();

        //entonces
        Assertions.assertEquals(rtaEsperada, rta);
    }

    @Test
    public void pruebaMenuVegetariano(){
        //dado
        Menu menu1 = new MenuVegetariano(1000.0, true,2);
        String rtaEsperada = "El total de su pedido es: 1014.04";

        //cuando
        String rta =  menu1.prepararMenu();

        System.out.println(rta);

        //entonces
        Assertions.assertEquals(rtaEsperada, rta);
    }
}