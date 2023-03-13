import java.time.LocalDate;

public class PacienteParticular extends Paciente{
    private double valorConsulta;
    private String dni;

    public PacienteParticular(Consulta consulta, LocalDate fechaNacimiento, String nombre, String apellido, boolean esPrimerConsulta, double valorConsulta, String dni) {
        super(consulta, fechaNacimiento, nombre, apellido, esPrimerConsulta);
        this.valorConsulta = valorConsulta;
        this.dni = dni;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }
}
