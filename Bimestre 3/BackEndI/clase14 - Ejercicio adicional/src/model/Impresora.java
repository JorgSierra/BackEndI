package model;

public class Impresora {
    private Integer ID;
    private String nombre;
    private String marca;
    private String color;

    public Impresora(String nombre, String marca, String color) {
        this.nombre = nombre;
        this.marca = marca;
        this.color = color;
    }

    public Impresora(Integer ID, String nombre, String marca, String color) {
        this.ID = ID;
        this.nombre = nombre;
        this.marca = marca;
        this.color = color;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Impresora{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
