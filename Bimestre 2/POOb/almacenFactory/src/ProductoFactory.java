public class ProductoFactory {
    // Singleton
    private static ProductoFactory instance;

    private ProductoFactory(){}

    public static ProductoFactory getInstance() {
        if (instance == null){
            instance = new ProductoFactory();
        }
        return instance;
    }

    //Factory
    public  Producto getProducto(String type){
        switch (type){
            case "CAJA10X10":
                return new Caja(10,10,10);
            case "PELOTAFUTBOL":
                return new Pelota(11);
            case "PELOTATENIS":
                return new Pelota(0.32);
            default:
                return null;
        }
    }
}
