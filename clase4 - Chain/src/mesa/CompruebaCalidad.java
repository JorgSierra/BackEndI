package mesa;

import mesa.impl.Aceptado;
import mesa.impl.Envase;
import mesa.impl.Lote;
import mesa.impl.Peso;

public class CompruebaCalidad {
    public static AnalistaCalidad getChain(){
        AnalistaCalidad lote = new Lote();
        AnalistaCalidad peso = new Peso();
        AnalistaCalidad envase = new Envase();
        AnalistaCalidad aceptado = new Aceptado();

        lote.setSigAnalista(peso);
        peso.setSigAnalista(envase);
        envase.setSigAnalista(aceptado);

        return lote;
    }
}
