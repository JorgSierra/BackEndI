package presencial;

import java.util.ArrayList;

public class Cliente {
    public static void main(String[] args) {
        //necesito la fabrica
        ComputadoraFactory computadoraFactory= new ComputadoraFactory();
        Computadora pc1= computadoraFactory.getComputadora(16,500);
        Computadora pc2= computadoraFactory.getComputadora(8,500);
        Computadora pc3= computadoraFactory.getComputadora(16,500);
        Computadora pc4= computadoraFactory.getComputadora(8,500);

        System.out.println(pc1.toString());
        System.out.println(pc2.toString());
        System.out.println(pc3.toString());
        System.out.println(pc4.toString());
        pc3.setDiscoDuro(900);
        System.out.println("disco pc1:"+pc1.getDiscoDuro());
/*
        ArrayList<Computadora> computadorasNegocio=new ArrayList<>();
        for (int i=1;i<100000;i++){
            computadorasNegocio.add(computadoraFactory.getComputadora(20,800));
        }

        System.out.println("Cantidad final de objetos: "+Computadora.getContador());
*/
    }
}
