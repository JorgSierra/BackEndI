package mesa;

public class MenuInfantil extends Menu{
    private Integer cantidadJuguetes;

    public MenuInfantil(Double precioBase, Integer cantidadJuguetes) {
        super(precioBase);
        this.cantidadJuguetes = cantidadJuguetes;
    }

    public Integer getCantidadJuguetes() {
        return cantidadJuguetes;
    }

    @Override
    public void armarMenu() {
        System.out.println("Estos son los ingredientes de un menu infantil");
    }

    @Override
    public Double calcularPrecio() {
        return super.getPrecioBase() + (3 * this.getCantidadJuguetes());
    }
}
