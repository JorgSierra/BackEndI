package presencial;

public class Cliente {
    public static void main(String[] args) {
        String nombrePeliculaBuscada="Pelicula4";
        IP ip= new IP(190,11,50,99);
        GrillaDePeliculasProxy grilla= new GrillaDePeliculasProxy(ip);
        //consultamos la pelicula4
        try{
            Pelicula peliculaBuscada=grilla.getPelicula(nombrePeliculaBuscada);
            System.out.println("Link de la "+nombrePeliculaBuscada+ ": "
            +peliculaBuscada.getLink());
        }
        catch (PeliculaNoHabilitadaException e){
            e.printStackTrace();
        }
    }
}
