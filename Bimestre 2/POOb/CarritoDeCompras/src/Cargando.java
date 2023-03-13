public class Cargando implements CarritoState{
    private Carrito carrito;

    public Cargando(Carrito carrito) {
        this.carrito = carrito;
    }

    @Override
    public void agregarProducto(Producto producto) {
        this.carrito.addProducto(producto);
    }

    @Override
    public void cancelar() {
        this.carrito.emptyCart();
        this.carrito.setState(new Vacio(this.carrito));
    }

    @Override
    public void volver() {
        this.carrito.emptyCart();
        this.carrito.setState(new Vacio(this.carrito));
    }

    @Override
    public void siguiente() {
        this.carrito.setState(new Pagando(this.carrito));
    }
}
