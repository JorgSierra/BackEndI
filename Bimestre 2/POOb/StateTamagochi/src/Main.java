public class Main {
    public static void main(String[] args) {
        Tamagochi tamagochi = new Tamagochi("Hugoooo");

        tamagochi.beber();
        System.out.println(tamagochi.getState());
        tamagochi.comer();
        System.out.println(tamagochi.getState());
        tamagochi.mimar();
        System.out.println(tamagochi.getState().getClass());

    }
}