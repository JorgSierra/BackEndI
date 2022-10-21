package mesas;

public abstract class Menu {
    private Double precioBase;

    public Menu(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public abstract void armarMenu();
    public abstract Double calcularPrecio();

    public String prepararMenu(){
        String rta = "Pedido no realizado";
        armarMenu();
        Double precio = calcularPrecio();
        if (precio > 0){
            rta = "El total de su pedido es: " + precio;
        }
        else{
            rta = "El precio no pudo ser calculado";
        }
        return rta;
    }

}
