 import dao.DB;
 import dao.DomicilioDAOH2;
 import model.Domicilio;
 import model.Odontologo;
 import model.Paciente;
 import org.junit.jupiter.api.Assertions;
 import org.junit.jupiter.api.BeforeAll;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;
import service.OdontologoService;
 import service.PacienteService;

 import java.time.LocalDate;
 import java.util.ArrayList;
import java.util.List;

public class PacienteTest {
    @Test
    public void listOf(){
        DB.dropCreateTables();
        Domicilio dom1 = new Domicilio("mañanitas", 10, "Horario", "Provinciano");
        Domicilio dom2 = new Domicilio("nochesitas", 20, "Horario", "Provinciano");
        Domicilio dom3 = new Domicilio("tardesitas", 30, "Horario","Provinciano");
        Domicilio dom4 = new Domicilio("siempre feliz", 40, "simpson", "Provinciano");

        PacienteService patService = new PacienteService();
        Paciente pat1 = new Paciente("Jorge", "Sierra", "1233456", LocalDate.of(2022,06,15), dom1);
        Paciente pat2 = new Paciente("Laura", "Morales", "123333", LocalDate.of(2022,06,15), dom2);
        Paciente pat3 = new Paciente("Keith", "Ames", "5673456", LocalDate.of(2022,06,15), dom3);
        Paciente pat4 = new Paciente("Lusper", "McFly", "5733456", LocalDate.of(2022,06,15), dom4);

        List<Paciente> pacienteListExpected = new ArrayList<>();
        pacienteListExpected.add(pat1);
        pacienteListExpected.add(pat2);
        pacienteListExpected.add(pat3);
        pacienteListExpected.add(pat4);
        System.out.println("Expected");
        for (Paciente i:
                pacienteListExpected) {
            System.out.println(i.toString());
        }

        patService.guardarPaciente(pat1);
        patService.guardarPaciente(pat2);
        patService.guardarPaciente(pat3);
        patService.guardarPaciente(pat4);
        List<Paciente> pacienteListResult = patService.listarPacientes();
        System.out.println("Result");
        for (Paciente i:
                pacienteListResult) {
            System.out.println(i.toString());
        }

        for (int i = 0; i < pacienteListExpected.size(); i++){
            Assertions.assertEquals(pacienteListExpected.get(i).toString(), pacienteListResult.get(i).toString());
        }
    }

    @Test
    public void deleteTest(){
        DB.dropCreateTables();
        Domicilio dom1 = new Domicilio("mañanitas", 10, "Horario", "Provinciano");
        Domicilio dom2 = new Domicilio("nochesitas", 20, "Horario", "Provinciano");
        Domicilio dom3 = new Domicilio("tardesitas", 30, "Horario","Provinciano");
        Domicilio dom4 = new Domicilio("siempre feliz", 40, "simpson", "Provinciano");

        PacienteService patService = new PacienteService();
        Paciente pat1 = new Paciente("Jorge", "Sierra", "1233456", LocalDate.of(2022,06,15), dom1);
        Paciente pat2 = new Paciente("Laura", "Morales", "123333", LocalDate.of(2022,06,15), dom2);
        Paciente pat3 = new Paciente("Keith", "Ames", "5673456", LocalDate.of(2022,06,15), dom3);
        Paciente pat4 = new Paciente("Lusper", "McFly", "5733456", LocalDate.of(2022,06,15), dom4);

        patService.guardarPaciente(pat1);
        patService.guardarPaciente(pat2);
        patService.guardarPaciente(pat3);
        patService.guardarPaciente(pat4);
        List<Paciente> pacienteListResult = patService.listarPacientes();
        System.out.println("List of 4");
        for (Paciente i:
                pacienteListResult) {
            System.out.println(i.toString());
        }
        Assertions.assertEquals(pacienteListResult.size(), 4);

        patService.eliminarPaciente(2);
        patService.eliminarPaciente(4);
        pacienteListResult = patService.listarPacientes();
        System.out.println("List of 2");
        for (Paciente i:
                pacienteListResult) {
            System.out.println(i.toString());
        }
        Assertions.assertEquals(pacienteListResult.size(), 2);

        DomicilioDAOH2 domAux = new DomicilioDAOH2();
        List<Domicilio> domicilioList = domAux.search();
        for (Domicilio i:
                domicilioList) {
            System.out.println(i.toString());
        }
        Assertions.assertEquals(2, domicilioList.size());
    }

    @Test
    public void updateTest(){
        DB.dropCreateTables();
        PacienteService patService = new PacienteService();

        Domicilio dom1 = new Domicilio("mañanitas", 10, "Horario", "Provinciano");
        Domicilio dom2 = new Domicilio("nochesitas", 20, "Horario", "Provinciano");

        Paciente pat1 = new Paciente("Jorge", "Sierra", "1233456", LocalDate.of(2022,06,15), dom1);
        patService.guardarPaciente(pat1);
        Paciente result = patService.buscarPacienteID(1);
        Assertions.assertEquals("Jorge", result.getNombre());
        Assertions.assertEquals("Sierra", result.getApellido());
        Assertions.assertEquals("1233456", result.getDni());
        Assertions.assertEquals(LocalDate.of(2022,06,15), result.getFechaIngreso());
        Assertions.assertEquals(dom1.getID(), result.getDomicilio().getID());
        Assertions.assertEquals(dom1.getCalle(), result.getDomicilio().getCalle());
        Assertions.assertEquals(dom1.getNumero(), result.getDomicilio().getNumero());
        Assertions.assertEquals(dom1.getLocalidad(), result.getDomicilio().getLocalidad());
        Assertions.assertEquals(dom1.getProvincia(), result.getDomicilio().getProvincia());

        pat1.setNombre("Pablo");
        pat1.setApellido("Palacios");
        pat1.setDni("123456789");
        pat1.setDomicilio(dom2);
        patService.modificarPaciente(pat1);
        result = patService.buscarPacienteID(1);
        dom2.setID(result.getDomicilio().getID());

        Assertions.assertEquals("Pablo", result.getNombre());
        Assertions.assertEquals("Palacios", result.getApellido());
        Assertions.assertEquals("123456789", result.getDni());
        Assertions.assertEquals(LocalDate.of(2022,06,15), result.getFechaIngreso());
        Assertions.assertEquals(dom2.getID(), result.getDomicilio().getID());
        Assertions.assertEquals(dom2.getCalle(), result.getDomicilio().getCalle());
        Assertions.assertEquals(dom2.getNumero(), result.getDomicilio().getNumero());
        Assertions.assertEquals(dom2.getLocalidad(), result.getDomicilio().getLocalidad());
        Assertions.assertEquals(dom2.getProvincia(), result.getDomicilio().getProvincia());
    }
}