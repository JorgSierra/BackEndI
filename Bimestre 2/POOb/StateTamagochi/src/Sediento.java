public class Sediento implements StateTamagochi{

   private Tamagochi tamagochi;

    public Sediento(Tamagochi tamagochi) {
        this.tamagochi = tamagochi;
    }

    @Override
    public void comer() {
       this.tamagochi.setState(new Triste(this.tamagochi));
    }

    @Override
    public void beber() {
     this.tamagochi.setState(new Feliz(this.tamagochi));
    }

    @Override
    public void mimar() {
     System.out.println("Estoy Sediento pero me estan mimando. ");
    }
}
