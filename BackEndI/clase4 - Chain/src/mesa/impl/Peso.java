package mesa.impl;

import mesa.AnalistaCalidad;
import mesa.Articulo;

public class Peso extends AnalistaCalidad {
    @Override
    public void analizar(Articulo articulo) {
        if(articulo.getPeso() >= 1200 && articulo.getPeso() <= 1300 && this.sigAnalista != null){
            this.sigAnalista.analizar(articulo);
        }
        else{
            System.out.println("El articulo no cumple con requerimientos de Peso");
        }
    }
}
