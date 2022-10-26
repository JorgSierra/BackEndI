import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendedorTest {

    @Test
    void pruebaNovatos(){
        Vendedor afi3 = new Afiliado("ASantiago");

        String rtaEsperada = "ASantiago tiene un total de 0 puntos y categoriza como novato";
        String rta = afi3.mostrarCategoria();

        Assertions.assertEquals(rtaEsperada, rta);
    }

    @Test
    void pruebaAprendices(){
        Empleado emp1 = new Empleado("EPedro",1); emp1.vender(2);

        Vendedor afi1 = new Afiliado("ARamon"); afi1.vender(4);
        Vendedor afi3 = new Afiliado("ASantiago");

        emp1.addAfiliado(afi1);
        emp1.addAfiliado(afi3);

        String rtaEsperada = "EPedro tiene un total de 35 puntos y categoriza como bueno";
        String rta = emp1.mostrarCategoria();

        Assertions.assertEquals(rtaEsperada, rta);
    }

    @Test
    void pruebaBuenos(){
        Empleado emp2 = new Empleado("EMaria",2); emp2.vender(6);

        String rtaEsperada = "EMaria tiene un total de 40 puntos y categoriza como bueno";
        String rta = emp2.mostrarCategoria();

        Assertions.assertEquals(rtaEsperada, rta);
    }

    @Test
    void pruebaMaestros(){
        Vendedor afiliado = new Afiliado("Juanito marcian"); afiliado.vender(4);

        String rtaEsperada = "Juanito marcian tiene un total de 60 puntos y categoriza como maestro";
        String rta = afiliado.mostrarCategoria();

        Assertions.assertEquals(rtaEsperada, rta);
    }
}