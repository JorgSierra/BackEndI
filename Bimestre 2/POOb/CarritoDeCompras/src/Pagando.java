public class Pagando implements CarritoState{
    private Carrito carrito;

    public Pagando(Carrito carrito) {
        this.carrito = carrito;
    }

    @Override
    public void agregarProducto(Producto producto) {
        System.out.println("Esperando aceptación de compra no se puede agregar mas productos!!");
    }

    @Override
    public void cancelar() {
        this.carrito.emptyCart();
        this.carrito.setState(new Vacio(this.carrito));
    }

    @Override
    public void volver() {
        this.carrito.setState(new Cargando(this.carrito));
    }

    @Override
    public void siguiente() {
        this.carrito.setState(new Cerrado(this.carrito));
    }
}
