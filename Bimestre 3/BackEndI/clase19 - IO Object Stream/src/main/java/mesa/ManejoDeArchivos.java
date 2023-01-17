package mesa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ManejoDeArchivos {
    public static void guardarContactos(List<Contacto> list, String ruta){
        try {
            FileOutputStream fs = new FileOutputStream(ruta);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(list);
            os.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Contacto> cargarContactos(String ruta){
        List<Contacto> result = null;
        try {
            FileInputStream fs = new FileInputStream(ruta);
            ObjectInputStream os = new ObjectInputStream(fs);
            result = (ArrayList)os.readObject();
            os.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
