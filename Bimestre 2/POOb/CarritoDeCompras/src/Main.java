public class Main {
    public static void main(String[] args) {

        Carrito carrito = new Carrito();
        System.out.println(carrito.getState().getClass());
        carrito.agregarProducto(new Producto("Producto1",1000));
        System.out.println(carrito.getState().getClass());
        carrito.addProducto(new Producto("Producto2",1000));
        System.out.println(carrito.getState().getClass());
        carrito.siguiente();
        System.out.println(carrito.getState().getClass());
        carrito.siguiente();
        System.out.println(carrito.getState().getClass());
        carrito.cancelar();
        System.out.println(carrito.getState().getClass());

    }
}