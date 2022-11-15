import dao.DB;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.ArrayList;
import java.util.List;

public class OdontologoTest {
    @Test
    public void listOfOdontologo(){
        OdontologoService odonService = new OdontologoService();
        DB.dropCreateTables();
        Odontologo odon1 = new Odontologo("ASDF","Pepito","Peras");
        Odontologo odon2 = new Odontologo("ASDF","Junito","Juanes");
        Odontologo odon3 = new Odontologo("ASDF","Jorge","Sierra");
        Odontologo odon4 = new Odontologo("ASDF","Laura","Juarez");

        List<Odontologo> odontologoListExpected = new ArrayList<>();
        odontologoListExpected.add(odon1);
        odontologoListExpected.add(odon2);
        odontologoListExpected.add(odon3);
        odontologoListExpected.add(odon4);
        System.out.println("Expected");
        for (Odontologo i:
                odontologoListExpected) {
            System.out.println(i.toString());
        }

        odonService.guardarOdontologo(odon1);
        odonService.guardarOdontologo(odon2);
        odonService.guardarOdontologo(odon3);
        odonService.guardarOdontologo(odon4);
        List<Odontologo> odontologoListResult = odonService.listarOdontologos();
        System.out.println("Result");
        for (Odontologo i:
                odontologoListResult) {
            System.out.println(i.toString());
        }

        for (int i = 0; i < odontologoListExpected.size(); i++){
            Assertions.assertEquals(odontologoListExpected.get(i).toString(), odontologoListResult.get(i).toString());
        }
    }

    @Test
    public void deleteTest(){
        OdontologoService odonService = new OdontologoService();
        DB.dropCreateTables();

        Odontologo odon1 = new Odontologo("ASDF","Pepito","Peras");
        Odontologo odon2 = new Odontologo("ASDF","Junito","Juanes");
        Odontologo odon3 = new Odontologo("ASDF","Jorge","Sierra");
        Odontologo odon4 = new Odontologo("ASDF","Laura","Juarez");
        odonService.guardarOdontologo(odon1);
        odonService.guardarOdontologo(odon2);
        odonService.guardarOdontologo(odon3);
        odonService.guardarOdontologo(odon4);
        List<Odontologo> odontologoListResult = odonService.listarOdontologos();
        System.out.println("List of 4");
        for (Odontologo i:
                odontologoListResult) {
            System.out.println(i.toString());
        }
        Assertions.assertEquals(odontologoListResult.size(), 4);

        odonService.eliminarOdontologo(2);
        odonService.eliminarOdontologo(4);
        odontologoListResult = odonService.listarOdontologos();
        System.out.println("List of 2");
        for (Odontologo i:
                odontologoListResult) {
            System.out.println(i.toString());
        }
        Assertions.assertEquals(odontologoListResult.size(), 2);
    }

    @Test
    public void updateTest(){
        OdontologoService odonService = new OdontologoService();
        DB.dropCreateTables();

        Odontologo odon1 = new Odontologo("ASDF","Pepito","Peras");
        odonService.guardarOdontologo(odon1);
        Odontologo result = odonService.buscarOdontologoID(1);
        Assertions.assertEquals(result.getMatricula(), "ASDF");

        odon1.setMatricula("QWERTY");
        odonService.modificarOdontologo(odon1);
        result = odonService.buscarOdontologoID(1);
        Assertions.assertEquals(result.getMatricula(), "QWERTY");
    }
}