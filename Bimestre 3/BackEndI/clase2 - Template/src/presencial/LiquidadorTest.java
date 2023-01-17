package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LiquidadorTest {
    @Test
    public void pruebaLiquidacionEmpleadoEfectivo(){
        //dado
        Empleado empleado= new EmpleadoEfectivo("Juan",
                "Perez","8457451258452416",
                75000.25,5284.0,5984.0);
        Liquidador liquidador= new LiquidadorEmpleadoEfectivo();
        String respEsperada="La liquidación generada es un documento escrito. Saldo a liquidar: 74300.25";
        //cuando
        String liquidacionFinal=liquidador.liquidarSueldo(empleado);
        //entonces
        Assertions.assertEquals(respEsperada,liquidacionFinal);
    }
}
