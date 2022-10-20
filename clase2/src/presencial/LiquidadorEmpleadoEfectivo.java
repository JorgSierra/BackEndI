package presencial;

public class LiquidadorEmpleadoEfectivo extends Liquidador{
    @Override
    protected Double calcularSueldo(Empleado empleado) {
        Double respuesta=0.0;
        if (empleado instanceof EmpleadoEfectivo){
            EmpleadoEfectivo emp=(EmpleadoEfectivo) empleado;
            respuesta=emp.getSueldoBasico()+emp.getPremios()-emp.getDescuentos();
        }
        return respuesta;
    }

    @Override
    protected String emitirRecibo(Empleado empleado) {
        return "La liquidación generada es un documento escrito.";
    }
}
