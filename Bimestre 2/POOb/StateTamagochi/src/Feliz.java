public class Feliz implements StateTamagochi{
    private Tamagochi tamagochi;

    public Feliz(Tamagochi tamagochi){
        this.tamagochi = tamagochi;
    }

    public void comer(){
        this.tamagochi.setState(new Sediento(this.tamagochi));
    }
    public void beber(){
        this.tamagochi.setState(new Hambriento(this.tamagochi));
    }
    public void mimar(){
        System.out.println("Estoy feliz y me estan mimando");
    }
}
