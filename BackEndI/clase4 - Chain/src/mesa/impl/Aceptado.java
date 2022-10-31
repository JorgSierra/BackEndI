package mesa.impl;

import mesa.AnalistaCalidad;
import mesa.Articulo;

public class Aceptado extends AnalistaCalidad {
    @Override
    public void analizar(Articulo articulo) {
        System.out.println("El articulo fue aceptado");
    }
}
