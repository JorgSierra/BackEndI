public class Cliente {
    private int numeroCliente;
    private String apellido;
    private String dni;
    private String cuit;

    public Cliente(int numeroCliente, String apellido, String dni, String cuit) {
        this.numeroCliente = numeroCliente;
        this.apellido = apellido;
        this.dni = dni;
        this.cuit = cuit;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getCuit() {
        return cuit;
    }
}
