public class Triste implements StateTamagochi{

    private Tamagochi tamagochi;

    public Triste(Tamagochi tamagochi) {
        this.tamagochi = tamagochi;
    }

    @Override
    public void comer() {
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Hugoooooooooooo");
    }

    @Override
    public void beber() {
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("Beep");
        System.out.println("+*+*+-+/**/+");
    }

    @Override
    public void mimar() {
        this.tamagochi.setState(new Feliz(this.tamagochi));
    }
}
