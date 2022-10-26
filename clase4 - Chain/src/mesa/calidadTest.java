package mesa;

import org.junit.jupiter.api.Test;

public class calidadTest {
    @Test
    void fallaLote(){
        Articulo art = new Articulo("Chancla","sano",900,1250);
        AnalistaCalidad analista = CompruebaCalidad.getChain();

        analista.analizar(art);
    }

    @Test
    void fallaPeso(){
        Articulo art = new Articulo("Chancla","casi sano",1000,1199);
        AnalistaCalidad analista = CompruebaCalidad.getChain();

        analista.analizar(art);
    }

    @Test
    void fallaEnvasado(){
        Articulo art = new Articulo("Chancla","roto",1000,1250);
        AnalistaCalidad analista = CompruebaCalidad.getChain();

        analista.analizar(art);
    }

    @Test
    void aceptado(){
        Articulo art = new Articulo("Chancla","casi sano",1000,1250);
        AnalistaCalidad analista = CompruebaCalidad.getChain();

        analista.analizar(art);
    }
}
