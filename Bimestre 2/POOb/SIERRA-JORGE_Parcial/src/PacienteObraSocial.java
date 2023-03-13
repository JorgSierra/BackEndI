import java.time.LocalDate;

public class PacienteObraSocial extends Paciente implements Comparable{
    private String nombreObraSocial;
    private int numeroAsociado;

    public PacienteObraSocial(Consulta consulta, LocalDate fechaNacimiento, String nombre, String apellido, boolean esPrimerConsulta, String nombreObraSocial, int numeroAsociado) {
        super(consulta, fechaNacimiento, nombre, apellido, esPrimerConsulta);
        this.nombreObraSocial = nombreObraSocial;
        this.numeroAsociado = numeroAsociado;
    }

    @Override
    public int compareTo(Object o) {
        return this.numeroAsociado - ((PacienteObraSocial)o).numeroAsociado;
    }
}
