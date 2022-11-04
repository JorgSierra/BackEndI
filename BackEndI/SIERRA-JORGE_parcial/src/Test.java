import dao.DB;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import service.OdontologoService;

import java.util.ArrayList;
import java.util.List;

public class Test {
    @org.junit.jupiter.api.Test
    public void odonGuardado(){
        OdontologoService odonService = new OdontologoService();
        DB.crearTabla();
        Odontologo odon1 = new Odontologo(1,"ASDF","Pepito","Peras");
        Odontologo odon2 = new Odontologo(2,"ASDF","Junito","Juanes");
        Odontologo odon3 = new Odontologo(3,"ASDF","Jorge","Sierra");
        Odontologo odon4 = new Odontologo(4,"ASDF","Laura","Juarez");

        List<Odontologo> odontologoListExpected = new ArrayList<>();
        odontologoListExpected.add(odon1);
        odontologoListExpected.add(odon2);
        odontologoListExpected.add(odon3);
        odontologoListExpected.add(odon4);

        odonService.guardarOdontologo(odon1);
        odonService.guardarOdontologo(odon2);
        odonService.guardarOdontologo(odon3);
        odonService.guardarOdontologo(odon4);

        List<Odontologo> odontologoListResult = odonService.buscarTodosOdontologos();

        System.out.println("Expected");
        for (Odontologo i:
                odontologoListExpected) {
            System.out.println(i.toString());
        }

        System.out.println("Result");
        for (Odontologo i:
                odontologoListResult) {
            System.out.println(i.toString());
        }

        for (int i = 0; i < odontologoListExpected.size(); i++){
            Assertions.assertEquals(odontologoListExpected.get(i).toString(), odontologoListResult.get(i).toString());
        }


    }
}