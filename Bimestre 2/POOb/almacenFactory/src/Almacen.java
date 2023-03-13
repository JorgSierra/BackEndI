import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private List<Producto> productoList;

    public Almacen() {
        this.productoList = new ArrayList<>();
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void agregarProducto(Producto producto){
        this.productoList.add(producto);
    }

    public double calcularEspacioNecesario(){
        double espacioTotal = 0;
        for (Producto producto:
             this.productoList) {
            espacioTotal += producto.calcularEspacio();
        }
        return espacioTotal;
    }
}
