package mesa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contacto> list = new ArrayList<>();
        Contacto c1 = new Contacto("Jorge","Sierra","mailing","Phone");
        Contacto c2 = new Contacto("Nubia","Vargas","mailing1","Phone4");
        Contacto c3 = new Contacto("Laura","Morales","mailing2","Phone3");
        Contacto c4 = new Contacto("Keith","Ames","mailing3","Phone2");
        Contacto c5 = new Contacto("Andres","Vargas","mailing4","Phone1");
        
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
        
        ManejoDeArchivos.guardarContactos(list, "salida.txt");
        
        List<Contacto> resultado = ManejoDeArchivos.cargarContactos("salida.txt");

        System.out.println("Listado obtenido de archivo");
        for (Contacto c:
             resultado) {
            System.out.println(c);
        }
        
    }
}
