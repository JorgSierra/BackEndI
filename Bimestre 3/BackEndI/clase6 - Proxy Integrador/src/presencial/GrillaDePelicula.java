package presencial;

public class GrillaDePelicula implements IGrillaDePeliculas{
    @Override
    public Pelicula getPelicula(String nombrePelicula) {
        //service
        Pelicula peliculaRespuesta=null;
        switch (nombrePelicula){
            case "Pelicula1":
                peliculaRespuesta= new Pelicula("Pelicula1",
                        "Argentina","www.suprapelis.com/Pelicula1");
                break;
            case "Pelicula2":
                peliculaRespuesta= new Pelicula("Pelicula2",
                        "Argentina","www.suprapelis.com/Pelicula2");
                break;
            case "Pelicula3":
                peliculaRespuesta= new Pelicula("Pelicula3",
                        "Brasil","www.suprapelis.com/Pelicula3");
                break;
            case "Pelicula4":
                peliculaRespuesta= new Pelicula("Pelicula4",
                        "Colombia","www.suprapelis.com/Pelicula4");
                break;
            case "Pelicula5":
                peliculaRespuesta= new Pelicula("Pelicula5",
                        "Uruguay","www.suprapelis.com/Pelicula5");
                break;
        }
        return peliculaRespuesta;
    }
}
