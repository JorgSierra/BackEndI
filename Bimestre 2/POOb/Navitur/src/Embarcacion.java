public abstract class Embarcacion {
    private double valorBase;
    private double valorAdicional;
    private double eslora;
    private int anioFabricacion;
    private Capitan capitan;

    public Embarcacion(double valorBase, double valorAdicional, double eslora, int anioFabricacion, Capitan capitan) {
        this.valorBase = valorBase;
        this.valorAdicional = valorAdicional;
        this.eslora = eslora;
        this.anioFabricacion = anioFabricacion;
        this.capitan = capitan;
    }

    public double calcularMontoAlquiler(){
        double total = this.valorBase;
        if (this.anioFabricacion > 2020){
            total += this.valorAdicional;
        }
        return total;
    }
}
