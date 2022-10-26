package mesa.impl;

import mesa.AnalistaCalidad;
import mesa.Articulo;

public class Envase extends AnalistaCalidad {
    @Override
    public void analizar(Articulo articulo) {
        if((articulo.getEnvasado().equals("sano") || articulo.getEnvasado().equals("casi sano")) && this.sigAnalista != null){
            this.sigAnalista.analizar(articulo);
        }
        else {
            System.out.println("El articulo no cumple con requerimientos de Envase");
        }
    }
}
