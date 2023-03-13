public class Vacio implements CarritoState{

    private Carrito carrito;

    public Vacio(Carrito carrito) {
        this.carrito = carrito;
    }

    @Override
    public void agregarProducto(Producto producto) {
        this.carrito.addProducto(producto);
        this.carrito.setState(new Cargando(this.carrito));
    }

    @Override
    public void cancelar() {
        System.out.println("No se hace nada porque ya esta vacio!!");
    }

    @Override
    public void volver() {
        System.out.println("No se hace nada porque ya esta vacio!!");
    }

    @Override
    public void siguiente() {
        this.carrito.setState(new Cargando(this.carrito));
    }
}
