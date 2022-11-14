import dao.DB;
import model.Impresora;
import service.ImpresoraService;

public class Cliente {
    public static void main(String[] args) {

        ImpresoraService ser = new ImpresoraService();
        DB.crearTabla();
        Impresora imp = new Impresora("Nombre imp","La marca","Sicas");
        Impresora imp1 = new Impresora("Nombre imp1","La marca","Sicas");
        Impresora imp2 = new Impresora("Nombre imp2","La marca","Sicas");
        Impresora imp3 = new Impresora("Nombre imp3","La marca","Sicas");

        ser.registrar(imp);
        ser.registrar(imp1);
        ser.registrar(imp2);
        ser.registrar(imp3);

        System.out.println(ser.buscar(1).toString());
        System.out.println(ser.buscar(2).toString());
        System.out.println(ser.buscar(3).toString());
        System.out.println(ser.buscar(4).toString());

        ser.eliminar(2);

        System.out.println(ser.buscar(1).toString());
        System.out.println(ser.buscar(3).toString());
        System.out.println(ser.buscar(4).toString());
        System.out.println(ser.buscar(2).toString());
    }
}