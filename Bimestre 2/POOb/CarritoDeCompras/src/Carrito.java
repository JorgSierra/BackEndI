import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private CarritoState state;
    private List<Producto> productoList;

    public Carrito() {
        this.productoList = new ArrayList<>();
        this.state = new Vacio(this);
    }

    public void addProducto(Producto producto){
        this.productoList.add(producto);
    }

    public void setState(CarritoState state) {
        this.state = state;
    }

    public CarritoState getState() {
        return state;
    }

    public void emptyCart(){
        this.productoList.clear();
    }

    public void agregarProducto(Producto producto) {
        this.state.agregarProducto(producto);
    }

    public void cancelar() {
        this.state.cancelar();
    }

    public void volver() {
        this.state.volver();
    }

    public void siguiente() {
        this.state.siguiente();
    }
}
