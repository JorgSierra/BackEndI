import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
    private LocalDate fechaConsulta;
    private String especialidad;
    private LocalTime hora;

    public Consulta(LocalDate fechaConsulta, String especialidad, LocalTime hora) {
        this.fechaConsulta = fechaConsulta;
        this.especialidad = especialidad;
        this.hora = hora;
    }
}
