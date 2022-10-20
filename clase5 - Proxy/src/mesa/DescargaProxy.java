package mesa;

public class DescargaProxy implements DescargaInterface{

    private Descarga descarga;

    public DescargaProxy() {
        this.descarga = new Descarga();
    }

    @Override
    public String descargarCancion(Usuario usr) {
        if (usr.getTipoUsuario().equals("Premium")){
            return this.descarga.descargarCancion(usr);
        }
        else {
            return "Compra tu suscripción premium para poder descargar";
        }
    }
}
