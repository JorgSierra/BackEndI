public class BusquedaImpl implements Busqueda{

    private BusquedaVuelo busquedaVuelo;
    private BusquedaHotel busquedaHotel;

    public BusquedaImpl() {
        busquedaVuelo = new BusquedaVuelo();
        busquedaHotel = new BusquedaHotel();
    }

    public void agregarHotel(Hotel hotel){
        busquedaHotel.agregarHotel(hotel);
    }

    public void agregarVuelo(Vuelo vuelo){
        busquedaVuelo.agregarVuelo(vuelo);
    }

    @Override
    public String busqueda(String fechaSalida, String fechaRegreso, String origen, String destino) {
        Vuelo vuelo =busquedaVuelo.buscarVuelo(fechaSalida,fechaRegreso,origen,destino);
        Hotel hotel = busquedaHotel.buscarHotel(fechaSalida, fechaRegreso, destino);
        if (vuelo != null && hotel != null){
            return "Vuelo: "+ vuelo.toString()+ "\nHotel: "+ hotel.toString();
        } return "No se encontro el hotel/vuelo";

    }
}
