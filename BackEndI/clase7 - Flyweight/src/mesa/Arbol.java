package mesa;

public class Arbol {
    private Integer alto, ancho;
    private String color;
    private static Integer contador = 0;

    public Arbol(Integer alto, Integer ancho, String color) {
        this.alto = alto;
        this.ancho = ancho;
        this.color = color;

        this.contador ++;
        System.out.println("Valor actual del contador: " + contador);
    }

    @Override
    public String toString() {
        return "Arbol{" +
                "alto=" + alto +
                ", ancho=" + ancho +
                ", color='" + color + '\'' +
                '}';
    }

    public Integer getAlto() {
        return alto;
    }

    public void setAlto(Integer alto) {
        this.alto = alto;
    }

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static Integer getContador() {
        return contador;
    }

    public static void setContador(Integer contador) {
        Arbol.contador = contador;
    }
}
