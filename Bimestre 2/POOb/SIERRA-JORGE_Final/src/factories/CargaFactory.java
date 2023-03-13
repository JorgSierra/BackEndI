package factories;

import classes.Carga;
import classes.Contenedor;
import classes.Simple;

public class CargaFactory {
    private static CargaFactory instance;
    public static final String CARGA_SIMPLE = "Carga simple";
    public static final String CARGA_CONTENEDOR = "Carga contenedor";

    private CargaFactory(){}

    public static CargaFactory getInstance(){
        if (instance == null){
            instance = new CargaFactory();
        }
        return instance;
    }

    public Carga crearCarga(String type, String nombre, String descripcion){
        switch (type){
            case CARGA_SIMPLE:
                return new Simple(nombre, descripcion);
            case CARGA_CONTENEDOR:
                return new Contenedor(nombre, descripcion);
        }
        return null;
    }

}
