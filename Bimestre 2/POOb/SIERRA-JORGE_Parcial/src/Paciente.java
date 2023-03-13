import java.time.LocalDate;

public abstract class Paciente {
    private Consulta consulta;
    private LocalDate fechaNacimiento;
    private String nombre;
    private String apellido;
    private boolean esPrimerConsulta;

    public Paciente(Consulta consulta, LocalDate fechaNacimiento, String nombre, String apellido, boolean esPrimerConsulta) {
        this.consulta = consulta;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.esPrimerConsulta = esPrimerConsulta;
    }

    public boolean necesitaEvaluacionInicial(){
        return this.esPrimerConsulta;
    }
}
