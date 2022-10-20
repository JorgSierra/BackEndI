package mesa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DescargaTest {
    @Test
    public void pruebaPremium(){
        Usuario usuario = new Usuario("1234", "Premium");
        DescargaProxy proxy = new DescargaProxy();
        String rtaEsperada = "La cancion del usuario: 1234 se esta descargando";
        String rtaObtenida = proxy.descargarCancion(usuario);
        Assertions.assertEquals(rtaEsperada, rtaObtenida);
    }

    @Test
    public void pruebaFree(){
        Usuario usuario = new Usuario("1234", "Free");
        DescargaProxy proxy = new DescargaProxy();
        String rtaEsperada = "Compra tu suscripción premium para poder descargar";
        String rtaObtenida = proxy.descargarCancion(usuario);
        Assertions.assertEquals(rtaEsperada, rtaObtenida);
    }
}
