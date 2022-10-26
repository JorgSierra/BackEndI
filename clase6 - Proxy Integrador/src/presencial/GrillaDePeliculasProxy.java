package presencial;

public class GrillaDePeliculasProxy implements IGrillaDePeliculas{
    private GrillaDePelicula grilla;
    private IP direccion;

    public GrillaDePeliculasProxy(IP direccion) {
        grilla= new GrillaDePelicula();
        this.direccion = direccion;
    }

    @Override
    public Pelicula getPelicula(String nombrePelicula) throws PeliculaNoHabilitadaException {
        //primero- buscar la pelicula
        //segundo- comparar el origen de la dirección con el pais de la pelicula
        //tercero- si son iguales ok, sino arrojar excepción
        Pelicula pelicula=grilla.getPelicula(nombrePelicula);
        if (!direccion.getPais().equals(pelicula.getPais())){
            throw new PeliculaNoHabilitadaException("La pelicula "+pelicula.getNombre()+
                    " no disponible en el pais "+direccion.getPais());
        }
        return pelicula;

    }
}
