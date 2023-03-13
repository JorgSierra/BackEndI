package Classes;

public class PizzaSimple implements Pizza{
    private String nombre, descripcion;
    private double precioBase;
    private boolean grande;

    public PizzaSimple(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public void setGrande(boolean grande) {
        this.grande = grande;
    }

    @Override
    public double calcularPrecio() {
        if (grande == true){
            return (this.precioBase * 2);
        }else {
            return this.precioBase;
        }
    }

    @Override
    public String toString() {
        return "PizzaSimple{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioBase=" + precioBase +
                ", grande=" + grande +
                '}';
    }
}
