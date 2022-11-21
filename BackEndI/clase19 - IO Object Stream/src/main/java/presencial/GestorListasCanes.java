package presencial;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class GestorListasCanes {
    public static void guardarListaCanes(List<Perro> lista, String archivo){
        FileOutputStream fos=null;
        try{
            fos=new FileOutputStream(archivo);
            //como voy a guardar la información, vamos a usar ObjectOutputStream
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            //el método writeObject guardar un objeto
            oos.writeObject(lista);
            oos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
