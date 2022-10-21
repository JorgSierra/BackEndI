package mesas;

public class MenuClasico extends Menu{
    public MenuClasico(Double precioBase) {
        super(precioBase);
    }

    @Override
    public void armarMenu() {
        System.out.println("Estos son los ingredientes de un menu clasico");
    }

    @Override
    public Double calcularPrecio() {
        return super.getPrecioBase();
    }
}
