import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Cliente {
    private static final String SQL_DROP_CREATE="DROP TABLE IF EXISTS ANIMALES; CREATE " +
            "TABLE ANIMALES (ID INT PRIMARY KEY," +
            " NOMBRE VARCHAR(100) NOT NULL," +
            " TIPO VARCHAR(100) NOT NULL)";

    public static void main(String[] args) {
        //quiero conectarme a la base de datos
        //necesito información sobre la misma
        Connection connection;
        //como tiran excepciones, coloco try catch
        try{
            connection=getConnection();
            //preparar nuestro mensaje a la base de datos
            Statement statement=connection.createStatement();
            statement.execute(SQL_DROP_CREATE);
            statement.execute("INSERT INTO ANIMALES VALUES (1,'Coco','gato')," +
                    "(2,'Minverva','perro'),(3,'Jona','hamster'),(4,'Lia','gato')," +
                    "(5,'Duke','perro')");
            ResultSet rs=statement.executeQuery("SELECT * FROM ANIMALES");
            //rs.next() hace dos cosas 1)mueve el puntero interno del resultset
            // 2) me indica si tengo un elemento, es decir me arroja un boolean
            while (rs.next()){
                System.out.println("Nombre: "+rs.getString(2)+" - "+
                        "Tipo: "+rs.getString(3));
            }
        }
        catch (Exception e){
            //aquí podría ir un logger de tipo error
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clase11",
                "sa","sa");
    }
}
