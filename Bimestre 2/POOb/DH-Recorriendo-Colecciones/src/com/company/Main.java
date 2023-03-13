package com.company;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.*;
import java.time.*;

public class Main {

    public static void main(String[] args) {
	    List nombres = new ArrayList();

        nombres.add("Juan");
        nombres.add("Mario");
        nombres.add("Carlos");
        nombres.add("Diego");
        nombres.add("Marcelo");
        nombres.add("Marcelo");

        System.out.println("Utilizando for");
        for(int i = 0; i < nombres.size(); i++) {
            System.out.println(nombres.get(i));
        }
        System.out.println("\n");

        System.out.println("Utilizando while y encontrando");
        int i = 0;
        boolean encontrado = false;
        while( i < nombres.size() && !encontrado)
        {
            if(nombres.get(i) == "Carlos")
                encontrado = true;
            System.out.println(nombres.get(i));
            i++;
        }
        System.out.println("\n");


        System.out.println("usando iterator");
        Iterator iterator = nombres.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println("\n");

        System.out.println("usando for each");
        for(Object nombre: nombres){
            System.out.println(nombre);
        }
        System.out.println("\n");


    }
}
