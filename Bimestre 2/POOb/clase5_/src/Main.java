public class Main {
    public static void main(String[] args) {
        Usuario user = new Usuario("Jorge","Clavesita");
        System.out.println("Hola: " + user.getNombre());
        System.out.println("Con clave: " + user.getClave());
        System.out.println("Puntaje: " + user.getPuntaje());
        user.aumentarPuntaje();
        System.out.println("Puntaje: " + user.getPuntaje());
        System.out.println("Nivel: " + user.getNivel());
        user.subirNivel();
        System.out.println("Nivel: " + user.getNivel());
        System.out.println("Antes del bonus: " + user.getPuntaje());
        user.bonus(125.4456);
        System.out.println("Luego del bonus: " + user.getPuntaje());
    }
}