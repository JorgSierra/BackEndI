package com.dh.clase23;

import com.dh.clase23.dao.DB;
import com.dh.clase23.dao.DomicilioDAOH2;
import com.dh.clase23.model.Domicilio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DomicilioTest {
    @Test
    public void listOf(){
        DomicilioDAOH2 dom = new DomicilioDAOH2();
        DB.dropCreateTables();
        Domicilio dom1 = new Domicilio("mañanitas", 10, "Horario", "Provinciano");
        Domicilio dom2 = new Domicilio("nochesitas", 20, "Horario", "Provinciano");
        Domicilio dom3 = new Domicilio("tardesitas", 30, "Horario","Provinciano");
        Domicilio dom4 = new Domicilio("siempre feliz", 40, "simpson", "Provinciano");

        List<Domicilio> domicilioListExpected = new ArrayList<>();
        domicilioListExpected.add(dom1);
        domicilioListExpected.add(dom2);
        domicilioListExpected.add(dom3);
        domicilioListExpected.add(dom4);
        System.out.println("Expected");
        for (Domicilio i:
                domicilioListExpected) {
            System.out.println(i.toString());
        }

        dom.save(dom1);
        dom.save(dom2);
        dom.save(dom3);
        dom.save(dom4);
        List<Domicilio> domicilioListResult = dom.search();
        System.out.println("Result");
        for (Domicilio i:
                domicilioListResult) {
            System.out.println(i.toString());
        }

        for (int i = 0; i < domicilioListExpected.size(); i++){
            Assertions.assertEquals(domicilioListExpected.get(i).toString(), domicilioListResult.get(i).toString());
        }
    }

    @Test
    public void deleteTest(){
        DomicilioDAOH2 dom = new DomicilioDAOH2();
        DB.dropCreateTables();
        Domicilio dom1 = new Domicilio("mañanitas", 10, "Horario", "Provinciano");
        Domicilio dom2 = new Domicilio("nochesitas", 20, "Horario", "Provinciano");
        Domicilio dom3 = new Domicilio("tardesitas", 30, "Horario","Provinciano");
        Domicilio dom4 = new Domicilio("siempre feliz", 40, "simpson", "Provinciano");
        dom.save(dom1);
        dom.save(dom2);
        dom.save(dom3);
        dom.save(dom4);
        List<Domicilio> domicilioListResult = dom.search();
        System.out.println("List of 4");
        for (Domicilio i:
                domicilioListResult) {
            System.out.println(i.toString());
        }
        Assertions.assertEquals(domicilioListResult.size(), 4);

        dom.delete(2);
        dom.delete(4);
        domicilioListResult = dom.search();
        System.out.println("List of 2");
        for (Domicilio i:
                domicilioListResult) {
            System.out.println(i.toString());
        }
        Assertions.assertEquals(domicilioListResult.size(), 2);
    }

    @Test
    public void updateTest(){
        DomicilioDAOH2 dom = new DomicilioDAOH2();
        DB.dropCreateTables();
        Domicilio dom1 = new Domicilio("mañanitas", 10, "Horario", "Provinciano");

        dom.save(dom1);
        Domicilio result = dom.searchID(1);
        Assertions.assertEquals(result.getCalle(), "mañanitas");

        dom1.setCalle("QWERTY");
        dom.update(dom1);
        result = dom.searchID(1);
        Assertions.assertEquals(result.getCalle(), "QWERTY");
    }
}