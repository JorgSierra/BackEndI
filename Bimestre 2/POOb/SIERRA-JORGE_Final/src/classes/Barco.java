package classes;

import java.util.ArrayList;
import java.util.List;

public class Barco {
    private String nombre;
    private List<Carga> cargaList;

    public Barco(String nombre) {
        this.nombre = nombre;
        this.cargaList = new ArrayList<>();
    }

    public void agregarCarga(Carga carga){
        this.cargaList.add(carga);
    }

    public List<String> mostrarCarga(){
        List<String> listadoCargas = new ArrayList<>();
        for (Carga carga:
             cargaList) {
            listadoCargas.add(carga.toString());
        }
        return listadoCargas;
    }
}
