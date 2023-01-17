package presencial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {
        //necesitamos la lista de perros
        List<Perro> canes= new ArrayList<>();
        canes.add(new Perro(1,"Taylor"));
        canes.add(new Perro(2,"Alma"));
        canes.add(new Perro(3,"Duke"));
        canes.add(new Perro(4,"Ruffus"));
        canes.add(new Perro(5,"Panchito"));
        canes.add(new Perro(6,"Batman"));
        canes.add(new Perro(7,"Cascote"));
        //necesitamos guardar la lista en disco
        FileOutputStream fos=null;
        try{
            fos=new FileOutputStream("Salida.txt");
            //como voy a guardar la información, vamos a usar ObjectOutputStream
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            //el método writeObject guardar un objeto
            oos.writeObject(canes);
            oos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //necesitamos recuperar la lista y mostrar por pantalla
        List<Perro> canes2=null;
        FileInputStream fis=null;
        try{
            //flujo de entrada
            fis= new FileInputStream("Salida.txt");
            ObjectInputStream ois= new ObjectInputStream(fis);
            //casteamos porque readObject() me devuelve un objeto de la clase Object
            //recordemos que los objetos no se olvidan de como nacen.
            canes2=(ArrayList)ois.readObject();
            ois.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        for (Perro perro:canes2) {
            System.out.println(perro);
        }
    }
}
