import java.util.ArrayList;
import java.util.List;

public class BusquedaVuelo {

    private List<Vuelo> vueloList;

    public BusquedaVuelo() {
        this.vueloList = new ArrayList<>();
    }

    public Vuelo buscarVuelo(String fechaSalida, String fechaRegreso, String origen, String destino){
        for (Vuelo vuelo :
                vueloList) {
            if (vuelo.getDestino().equals(destino)  &&  vuelo.getOrigen().equals(origen)  && vuelo.getFechaSalida().equals(fechaSalida)  && vuelo.getFechaRegreso().equals(fechaRegreso)) {
                return vuelo;
            }
        }

        return null;
    }

    public void agregarVuelo(Vuelo vuelo){
        vueloList.add(vuelo);
    }

}
