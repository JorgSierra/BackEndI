package mesa;

public class Usuario {
    private String idUsuario, tipoUsuario;

    public Usuario(String idUsuario, String tipoUsuario) {
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
}
