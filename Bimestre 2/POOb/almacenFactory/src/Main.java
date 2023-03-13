public class Main {
    public static void main(String[] args) {

        Almacen almacen = new Almacen();
        ProductoFactory factory = ProductoFactory.getInstance();
        almacen.agregarProducto(factory.getProducto("CAJA10X10"));
        almacen.agregarProducto(factory.getProducto("CAJA10X10"));
        almacen.agregarProducto(factory.getProducto("PELOTAFUTBOL"));
        almacen.agregarProducto(factory.getProducto("PELOTAFUTBOL"));
        almacen.agregarProducto(factory.getProducto("PELOTAFUTBOL"));
        almacen.agregarProducto(factory.getProducto("PELOTATENIS"));
        almacen.agregarProducto(factory.getProducto("PELOTATENIS"));
        almacen.agregarProducto(factory.getProducto("PELOTATENIS"));


        for (Producto producto:
             almacen.getProductoList()) {
            System.out.println(producto.toString());
        }

        System.out.println(almacen.calcularEspacioNecesario());
    }
}