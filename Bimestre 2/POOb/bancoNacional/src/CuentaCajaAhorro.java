public class CuentaCajaAhorro extends Cuenta {

    private int tasaInteres;

    public CuentaCajaAhorro(int numeroCliente, String apellido, String dni, String cuit, double saldo, int tasaInteres) {
        super(numeroCliente, apellido, dni, cuit, saldo);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public String extraer(double monto) {
        if (super.informarSaldo() > monto) {
            super.setSaldo(super.informarSaldo() - monto);
            return "Extraccíon realizada";
        }
        else{
            return "Saldo insuficiente";
        }
    }

    public void cobrarInteres(){
        double saldoFinal = super.informarSaldo() + (super.informarSaldo() * (this.tasaInteres / 100));
        super.setSaldo(saldoFinal);
    }

}
