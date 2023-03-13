public abstract class Cuenta extends Cliente{
    private double saldo;

    public Cuenta(int numeroCliente, String apellido, String dni, String cuit, double saldo) {
        super(numeroCliente, apellido, dni, cuit);
        this.saldo = saldo;
    }

    public void depositar(double monto){
        this.saldo += monto;
    }
    public double informarSaldo(){
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract String extraer(double monto);

}
