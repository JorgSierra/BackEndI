public class EmbarcacionYate extends Embarcacion implements Comparable{
    private int cantidadCamarotes;

    public EmbarcacionYate(double valorBase, double valorAdicional, double eslora, int anioFabricacion, Capitan capitan, int cantidadCamarotes) {
        super(valorBase, valorAdicional, eslora, anioFabricacion, capitan);
        this.cantidadCamarotes = cantidadCamarotes;
    }

    @Override
    public int compareTo(Object o) {
        EmbarcacionYate yateXParametro = (EmbarcacionYate) o;
        if (this.cantidadCamarotes > yateXParametro.cantidadCamarotes){
            return 1;
        }
        else if (this.cantidadCamarotes < yateXParametro.cantidadCamarotes){
            return -1;
        }
        else {
            return 0;
        }
    }
}
