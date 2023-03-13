public class Hambriento implements StateTamagochi{
    private Tamagochi tamagochi;

    public Hambriento(Tamagochi tamagochi) {
        this.tamagochi = tamagochi;
    }

    @Override
    public void comer() {
        tamagochi.setState(new Feliz(this.tamagochi));
    }

    @Override
    public void beber() {
        tamagochi.setState(new Triste(this.tamagochi));
    }

    @Override
    public void mimar() {
        System.out.println("Estoy hambriento pero me estan mimando");
    }
}
