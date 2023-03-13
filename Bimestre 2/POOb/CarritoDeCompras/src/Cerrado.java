public class Cerrado implements CarritoState{
    private Carrito carrito;

    public Cerrado(Carrito carrito) {
        this.carrito = carrito;
    }

    @Override
    public void agregarProducto(Producto producto) {
        System.out.println("Ya esta cerrado no se puede agregar producto!!");
    }

    @Override
    public void cancelar() {
        this.carrito.emptyCart();
        this.carrito.setState(new Vacio(this.carrito));
    }

    @Override
    public void volver() {
        System.out.println("Ya esta cerrado no se puede volver!!");
    }

    @Override
    public void siguiente() {
        this.carrito.emptyCart();
        this.carrito.setState(new Vacio(this.carrito));
    }
}
