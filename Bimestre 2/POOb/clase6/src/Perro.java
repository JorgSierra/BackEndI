public class Perro {
    private String nombre;
    private String raza;
    private int anioNacimiento;
    private Double peso;
    private boolean chip;
    private boolean lastimado;
    private boolean adopcion = false;

    public Perro (String raza, double peso, String nombre){
        this.raza = raza;
        this.peso = peso;
        this.nombre = nombre;
    }
    public Perro (boolean chip, boolean lastimado, String raza, double peso, String nombre){
        this.raza = raza;
        this.peso = peso;
        this.nombre = nombre;
        this.chip = chip;
        this.lastimado = lastimado;
    }
}
