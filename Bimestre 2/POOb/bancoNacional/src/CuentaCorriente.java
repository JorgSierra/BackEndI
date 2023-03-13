public class CuentaCorriente extends Cuenta{

    private double montoAutorizado;
    private double descubierto;

    public CuentaCorriente(int numeroCliente, String apellido, String dni, String cuit, double saldo, double montoAutorizado, double descubierto) {
        super(numeroCliente, apellido, dni, cuit, saldo);
        this.montoAutorizado = montoAutorizado;
        this.descubierto = 0;
    }

    @Override
    public String extraer(double monto) {
        if (super.informarSaldo() > monto) {
            super.setSaldo(super.informarSaldo() - monto);
            return "Extraccíon realizada";
        }
        else{
            if (this.montoAutorizado - this.descubierto > monto){
                this.descubierto += monto;
                return "Extraccíon realizada como giro descubierto";
            }
            else{
                return "No cuentas con saldo disponible";
            }
        }
    }
}
