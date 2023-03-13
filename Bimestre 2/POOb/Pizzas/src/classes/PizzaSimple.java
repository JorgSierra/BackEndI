package classes;

public class PizzaSimple implements Pizza{
    private String nombre, descripcion;
    private double precioBase;
    private boolean esGrande;

    public PizzaSimple(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public void setEsGrande(boolean esGrande) {
        this.esGrande = esGrande;
    }

    @Override
    public double calcularPrecio() {
        if (esGrande){
            return this.precioBase * 2;
        }
        else{
            return this.precioBase;
        }
    }

    @Override
    public String toString() {
        return "PizzaSimple{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + this.calcularPrecio() +
                '}';
    }
}
