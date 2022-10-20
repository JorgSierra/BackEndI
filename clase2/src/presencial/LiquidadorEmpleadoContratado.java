package presencial;

public class LiquidadorEmpleadoContratado extends Liquidador{
    @Override
    protected Double calcularSueldo(Empleado empleado) {
        // el sueldo es la operación canthoras*valorhora
        Double respuesta=0.0;
        //proceso
        if (empleado instanceof EmpleadoContratado){
            // (claseADondeQuieroIr)ObjetoDeInicio
            EmpleadoContratado emp=(EmpleadoContratado) empleado;
            //((EmpleadoContratado)empleado).getValorPorHora()
            respuesta=emp.getCantidadHoras()*emp.getValorPorHora();
        }
        return respuesta;
    }

    @Override
    protected String emitirRecibo(Empleado empleado) {
        return "La liquidación generada es un documento digital.";
    }
}
