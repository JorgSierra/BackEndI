import java.util.ArrayList;

public class Empleado extends Vendedor {
    private int aniosAntiguedad;
    private ArrayList<Vendedor> afiliados;
    public Empleado(String nombre, int aniosAntiguedad){
        super.nombre = nombre;
        super.PUNTOS_POR_VENTA = 5;
        this.aniosAntiguedad = aniosAntiguedad;
        this.afiliados = new ArrayList<>();
    }

    /*agrega un afiliado al empleado*/
     public void addAfiliado(Vendedor afiliado){
        this.afiliados.add(afiliado);
     }

    /*implementacion de metodo abstracto*/
    /* por cada afiliado obtiene 10
    por cada venta obtiene 5
    por cada anio de antiguedad obtiene 5 puntos*/
    @Override
    public int calcularPuntos() {
        return (this.afiliados.size() * 10) + (this.aniosAntiguedad * 5) + (super.ventas * super.PUNTOS_POR_VENTA);
    }
}
