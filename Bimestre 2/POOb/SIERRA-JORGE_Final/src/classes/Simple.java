package classes;

public class Simple implements Carga{
    private String nombre;
    private String descripcion;
    private double peso;
    private boolean refrigerado;

    public Simple(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    @Override
    public double calcularPeso() {
        if (this.refrigerado){
            return this.peso * 1.1;
        }
        else{
            return this.peso;
        }
    }

    @Override
    public String toString() {
        return "Simple{" +
                "nombre='" + nombre + '\'' +
                ", peso=" + calcularPeso() +
                '}';
    }
}
