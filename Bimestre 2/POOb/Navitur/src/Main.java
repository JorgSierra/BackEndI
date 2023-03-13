public class Main {
    public static void main(String[] args) {

        Capitan cap = new Capitan("Franco","Gonzales","hhhsss");

        Embarcacion velerito = new EmbarcacionVelero(2000.500,1000,5.85,2020,cap,4);
        System.out.println(velerito.calcularMontoAlquiler());
        System.out.println(((EmbarcacionVelero)velerito).evaluarTamanio());

        EmbarcacionVelero velero2 = new EmbarcacionVelero(3000,2000,8.85,2021,cap,5);
        System.out.println(velero2.calcularMontoAlquiler());
        System.out.println(velero2.evaluarTamanio());

        Embarcacion yate = new EmbarcacionYate(2000.500,1000,5.85,2020,cap,4);
        System.out.println(yate.calcularMontoAlquiler());

        EmbarcacionYate yate2 = new EmbarcacionYate(3000,2000,8.85,2021,cap,5);
        System.out.println(yate2.calcularMontoAlquiler());

        EmbarcacionYate yate3 = new EmbarcacionYate(3000,2000,8.85,2021,cap,5);
        System.out.println(yate2.calcularMontoAlquiler());

        System.out.println(((EmbarcacionYate)yate).compareTo(yate2));
        System.out.println(yate2.compareTo((yate)));

        System.out.println(yate3.compareTo(yate2));
        System.out.println(yate2.compareTo(yate3));

    }
}