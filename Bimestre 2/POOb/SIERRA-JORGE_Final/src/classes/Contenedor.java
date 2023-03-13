package classes;

import java.util.ArrayList;
import java.util.List;

public class Contenedor implements Carga{
    private String nombre;
    private String descripcion;
    private double pesoContenedor;
    private List<Carga> cargaList;

    public Contenedor(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cargaList = new ArrayList<>();
    }

    public void setPesoContenedor(double pesoContenedor) {
        this.pesoContenedor = pesoContenedor;
    }

    public void agregarCarga(Carga carga){
        this.cargaList.add(carga);
    }

    @Override
    public double calcularPeso() {
        double peso = 0;
        for (Carga carga:
             cargaList) {
            peso += carga.calcularPeso();
        }
        peso += this.pesoContenedor;
        return peso;
    }

    @Override
    public String toString() {
        return "Contenedor{" +
                "nombre='" + nombre + '\'' +
                ", peso=" + calcularPeso() +
                '}';
    }
}
