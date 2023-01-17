import java.util.ArrayList;
import java.util.List;

public class BusquedaHotel {

    private List<Hotel> hotelList;

    public BusquedaHotel() {
        this.hotelList = new ArrayList<>();
    }

    public Hotel buscarHotel(String fechaEntrada, String fechaSalida, String ciudad){
        for (Hotel hotel :
                hotelList) {
            if (hotel.getFechaEntrada().equals(fechaEntrada)  && hotel.getFechaSalida().equals(fechaSalida)  && hotel.getCiudad().equals(ciudad)){
                return hotel;
            }
        }

        return null;
    }

    public void agregarHotel(Hotel hotel){
        hotelList.add(hotel);
    }

}
