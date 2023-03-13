import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //PIEDRA = "1";
        //PAPEL = "2";
        //TIJERA = "3";
        String nombreJugador1;
        String nombreJugador2;
        String option1;
        String option2;
        int winStatus;
        int contador1 = 0;
        int contador2 = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del Jugador 1");
        nombreJugador1 = sc.nextLine();
        System.out.println("Ingrese el nombre del Jugador 2");
        nombreJugador2 = sc.nextLine();

        boolean validOption = false;
        boolean endGame = false;
        do{
            do{
                System.out.println("Ingrese opcion de Jugador 1 ¿Piedra (1), papel (2) o tijera (3)?");
                option1 = sc.nextLine();
                if (option1.equals("*")){
                    endGame = true;
                    validOption = true;
                } else if (option1.equals("1") || option1.equals("2") || option1.equals("3")){
                    validOption = true;
                }
            }while(!validOption);

            if (!endGame){
                validOption = false;
                do{
                    System.out.println("Ingrese opcion de Jugador 2 ¿Piedra (1), papel (2) o tijera (3)?");
                    option2 = sc.nextLine();
                    if (option2.equals("1") || option2.equals("2") || option2.equals("3")){
                        validOption = true;
                    }
                }while(!validOption);

                winStatus = cualGana(option1, option2);
                if (winStatus == 0){
                    System.out.println("Es un empate");
                }
                else if (winStatus == 1){
                    System.out.println("Gana " + nombreJugador1);
                    contador1++;
                }
                else if (winStatus == 2){
                    System.out.println("Gana " + nombreJugador2);
                    contador2++;
                }
                System.out.println("Puntuación: ");
                System.out.println(nombreJugador1 + ": "+ contador1);
                System.out.println(nombreJugador2 + ": "+ contador2);
                validOption = false;
            }
        }while(!endGame);

        System.out.println("GAME OVER");
        System.out.println(nombreJugador1 + ": "+ contador1);
        System.out.println(nombreJugador2 + ": "+ contador2);
        if (contador1 > contador2){
            System.out.println(nombreJugador1 + " ES EL GANADOR DEL JUEGO");
        }
        else if (contador1 < contador2){
            System.out.println(nombreJugador2 + " ES EL GANADOR DEL JUEGO");
        }
        else{
            System.out.println("ES UN EMPATE");
        }
    }
    public static int cualGana(String J1, String J2){
        int response = 99;
        if (J1.equals(J2)){
            response = 0;
        }
        else {
            switch (J1) {
                case "1":
                    if (J2.equals("2")) {
                        response = 2;
                    } else {
                        response = 1;
                    }
                    break;
                case "2":
                    if (J2.equals("1")) {
                        response = 1;
                    } else {
                        response = 2;
                    }
                    break;
                case "3":
                    if (J2.equals("1")) {
                        response = 2;
                    } else {
                        response = 1;
                    }
                    break;
            }
        }
        return response;
    }
}