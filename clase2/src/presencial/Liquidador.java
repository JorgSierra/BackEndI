package presencial;

public abstract class Liquidador {
    public String liquidarSueldo(Empleado empleado){
        String respuesta="La liquidación no pudo se calculada";
        //paso 1 - calcular el sueldo
        Double sueldo=calcularSueldo(empleado);
        //paso 2 - emitir el recibo si se pudo realizar el paso 1
        if (sueldo>0.0){
            String recibo=emitirRecibo(empleado);
            //paso 3 - depositar el sueldo en la cuenta
            String deposito=depositarSueldo(empleado);
            respuesta=recibo+" Saldo a liquidar: "+sueldo;
        }
        //paso 4 - devolver el String final (return)
        return respuesta;
    }
    protected abstract Double calcularSueldo(Empleado empleado);
    protected abstract String emitirRecibo(Empleado empleado);
    private String depositarSueldo(Empleado empleado){
        return "Orden de deposito en la cuenta N° "+empleado.getCuentaBancaria();
    }
}
