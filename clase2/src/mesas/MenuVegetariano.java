package mesas;

public class MenuVegetariano extends Menu{
    private Boolean conEspecias;
    private Integer cantidadSalsas;

    public MenuVegetariano(Double precioBase, Boolean conEspecias, Integer cantidadSalsas) {
        super(precioBase);
        this.conEspecias = conEspecias;
        this.cantidadSalsas = cantidadSalsas;
    }

    public Boolean getConEspecias() {
        return conEspecias;
    }

    public Integer getCantidadSalsas() {
        return cantidadSalsas;
    }

    @Override
    public void armarMenu() {
        System.out.println("Estos son los ingredientes de un menu vegetariano");
    }

    @Override
    public Double calcularPrecio() {
        Double precio = 0.0;
        precio = super.getPrecioBase() + (2 * this.getCantidadSalsas());
        if (this.getConEspecias()) {
            precio *= 1.01;
        }
        return precio;
    }
}
