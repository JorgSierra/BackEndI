import java.time.*;

public class Main {
    public static void main(String[] args) {
        Consulta psiquiatria = new Consulta(LocalDate.now(),"psiquiatria",LocalTime.now());
        Consulta neurologia = new Consulta(LocalDate.now(),"neurologia",LocalTime.of(14,0));
        LocalDate nacimiento = LocalDate.of(1994,6,15);

        PacienteParticular particular = new PacienteParticular(psiquiatria, nacimiento, "Harry", "Potter", true, 300000, "10355584564");
        PacienteObraSocial obraSocial = new PacienteObraSocial(neurologia,nacimiento,"Daft","Punk",false,"Sanitas",1);
        PacienteObraSocial obraSocialmayor = new PacienteObraSocial(neurologia,nacimiento,"Gabriel","Garcia",false,"Sanitas",2);
        Paciente elPoliObra = new PacienteObraSocial(psiquiatria,nacimiento,"Poli", "Morph", true, "LaObraDeDios", 5);
        Paciente elPoliPart = new PacienteParticular(neurologia,nacimiento,"Poli", "Morfi", false, 500000,"1234556678899");

        System.out.println("Necesita evaluacion Inicial?");
        System.out.println(particular.necesitaEvaluacionInicial() ? "Si" : "No");
        System.out.println(obraSocial.necesitaEvaluacionInicial() ? "Si" : "No");
        System.out.println(obraSocialmayor.necesitaEvaluacionInicial() ? "Si" : "No");
        System.out.println(elPoliObra.necesitaEvaluacionInicial() ? "Si" : "No");
        System.out.println(elPoliPart.necesitaEvaluacionInicial() ? "Si" : "No" + "\n");

        System.out.println("Cuanto cuesta la consulta particular?");
        System.out.println(particular.getValorConsulta());
        System.out.println(((PacienteParticular)elPoliPart).getValorConsulta() + "\n");

        System.out.println("Comparación de obra social (menor)?");
        System.out.println(obraSocial.compareTo(obraSocialmayor));
        System.out.println(obraSocial.compareTo(elPoliObra));
        System.out.println(obraSocialmayor.compareTo(elPoliObra) + "\n");

        System.out.println("Comparación de obra social (mayor)?");
        System.out.println(obraSocialmayor.compareTo(obraSocial));
        System.out.println(((PacienteObraSocial)elPoliObra).compareTo(obraSocial));
        System.out.println(((PacienteObraSocial)elPoliObra).compareTo(obraSocialmayor) + "\n");

        System.out.println("Comparación de obra social (igual)?");
        System.out.println(obraSocial.compareTo(obraSocial));
        System.out.println(obraSocialmayor.compareTo(obraSocialmayor));
        System.out.println(((PacienteObraSocial)elPoliObra).compareTo(elPoliObra) + "\n");
    }
}