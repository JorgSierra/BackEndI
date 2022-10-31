package mesa;

public class Bosque {
    public static void main(String[] args) {
        ArbolFactory factoria = new ArbolFactory();

        Arbol ar1 = factoria.getArbol(ArbolFactory.TIPO1);
        Arbol ar2 = factoria.getArbol(ArbolFactory.TIPO1);
        Arbol ar3 = factoria.getArbol(ArbolFactory.TIPO1);
        Arbol ar4 = factoria.getArbol(ArbolFactory.TIPO2);
        Arbol ar5 = factoria.getArbol(ArbolFactory.TIPO2);
        Arbol ar6 = factoria.getArbol(ArbolFactory.TIPO2);
        Arbol ar7 = factoria.getArbol(ArbolFactory.TIPO2);
        Arbol ar8 = factoria.getArbol(ArbolFactory.TIPO2);

        System.out.println(ar1.toString());
        System.out.println(ar2.toString());
        System.out.println(ar3.toString());
        System.out.println(ar4.toString());
        System.out.println(ar5.toString());
        System.out.println(ar6.toString());
        System.out.println(ar7.toString());
        System.out.println(ar8.toString());

        System.out.println("Cantidad final de objetos: "+ Arbol.getContador());

    }
}