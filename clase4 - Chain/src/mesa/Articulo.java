package mesa;

public class Articulo {
    private String nombre, envasado;
    private int lote, peso;

    public Articulo(String nombre, String envasado, int lote, int peso) {
        this.nombre = nombre;
        this.envasado = envasado;
        this.lote = lote;
        this.peso = peso;
    }

    public String getEnvasado() {
        return envasado;
    }

    public int getLote() {
        return lote;
    }

    public int getPeso() {
        return peso;
    }
}
