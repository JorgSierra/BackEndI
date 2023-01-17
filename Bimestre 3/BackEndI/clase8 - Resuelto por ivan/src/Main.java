public class Main {
    public static void main(String[] args) {

        Vuelo v1 = new Vuelo("01/01/01", "02/09/2022", "X", "Y", "576y54605746");

        Hotel h1 = new Hotel("01/01/01", "02/09/2022", "Y", "Hotel de jusepe");

        BusquedaImpl b1 = new BusquedaImpl();
        b1.agregarVuelo(v1);
        b1.agregarHotel(h1);
        System.out.println(b1.busqueda("01/01/01", "02/09/2022", "X", "Y"));
        System.out.println(b1.busqueda("01/02/01", "02/08/2022", "X", "Y"));



    }
}