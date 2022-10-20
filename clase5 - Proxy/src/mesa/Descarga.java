package mesa;

public class Descarga implements DescargaInterface{
    @Override
    public String descargarCancion(Usuario usr) {
        return "La cancion del usuario: " + usr.getIdUsuario() + " se esta descargando";
    }
}
