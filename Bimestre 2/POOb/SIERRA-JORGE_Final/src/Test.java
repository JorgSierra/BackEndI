import classes.Barco;
import classes.Carga;
import classes.Contenedor;
import classes.Simple;
import factories.CargaFactory;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        Barco miBarquito = new Barco("Sailing to infinity");
        CargaFactory factory = CargaFactory.getInstance();

        Carga tele = factory.crearCarga(CargaFactory.CARGA_SIMPLE,"TV 32' LCD","Super televisor pequeño");
        ((Simple)tele).setPeso(3);
        ((Simple)tele).setRefrigerado(false);

        Carga medicamentos = factory.crearCarga(CargaFactory.CARGA_SIMPLE,"Caja de medicamentos","Medicamentos potentes para cualquier mal");
        ((Simple)medicamentos).setPeso(2);
        ((Simple)medicamentos).setRefrigerado(true);

        Carga container = factory.crearCarga(CargaFactory.CARGA_CONTENEDOR,"Contenedor","Tiene un tele y medicamentos");
        ((Contenedor)container).setPesoContenedor(100);
        ((Contenedor)container).agregarCarga(tele);
        ((Contenedor)container).agregarCarga(medicamentos);

        miBarquito.agregarCarga(tele);
        miBarquito.agregarCarga(medicamentos);
        miBarquito.agregarCarga(container);

        List<String> contenidoBarco = miBarquito.mostrarCarga();

        for (String item:
             contenidoBarco) {
            System.out.println(item);
        }

    }
}