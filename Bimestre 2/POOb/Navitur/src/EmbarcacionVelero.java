public class EmbarcacionVelero extends Embarcacion{
    private int cantidadMastiles;

    public EmbarcacionVelero(double valorBase, double valorAdicional, double eslora, int anioFabricacion, Capitan capitan, int cantidadMastiles) {
        super(valorBase, valorAdicional, eslora, anioFabricacion, capitan);
        this.cantidadMastiles = cantidadMastiles;
    }

    public boolean evaluarTamanio(){
        if (this.cantidadMastiles > 4){
            return true;
        }
        else {
            return false;
        }
    }
}
