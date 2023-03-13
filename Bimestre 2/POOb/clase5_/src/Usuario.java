public class Usuario {
    private String nombre;
    private String clave;
    private double puntaje = 0;
    private int nivel = 0;

    public Usuario(String nombre, String clave){
        this.nombre = nombre;
        this.clave = clave;
    }
    public void aumentarPuntaje(){
        this.puntaje++;
    }
    public void subirNivel() {
        this.nivel++;
    }
    public void bonus(double valor){
        this.puntaje += valor;
    }
    public double getPuntaje(){
        return this.puntaje;
    }
    public int getNivel() {
        return this.nivel;
    }
    public String getClave() {
        return this.clave;
    }
    public String getNombre() {
        return this.nombre;
    }
}
