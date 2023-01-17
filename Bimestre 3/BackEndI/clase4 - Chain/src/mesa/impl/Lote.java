package mesa.impl;

import mesa.AnalistaCalidad;
import mesa.Articulo;

public class Lote extends AnalistaCalidad{
    @Override
    public void analizar(Articulo articulo) {
        if(articulo.getLote() >= 1000 && articulo.getLote() <= 2000 && this.sigAnalista != null){
            this.sigAnalista.analizar(articulo);
        }
        else{
            System.out.println("El articulo no cumple con requerimientos de Lote");
        }
    }
}
