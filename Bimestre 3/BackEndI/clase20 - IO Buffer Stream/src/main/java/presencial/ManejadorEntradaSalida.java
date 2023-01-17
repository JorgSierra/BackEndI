package presencial;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

public class ManejadorEntradaSalida {
    public static void guardarListaEmpleadosFormatoEspecial(
            List<Empleado> empleados){
       //vamos a guardar, pensamos en flujos de salida
        FileOutputStream fos=null;
        try{
            fos= new FileOutputStream("empleados.txt");
            //necesitamos otra clase para guardar, vamos a usar un buffer
            BufferedOutputStream bos= new BufferedOutputStream(fos);
            //vamos a recorrer la lista
            for (Empleado empleado:empleados) {
                String linea= empleado.toString()+"\n";
                bos.write(linea.getBytes());
            }
            bos.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
