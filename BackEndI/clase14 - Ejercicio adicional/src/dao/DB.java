package dao;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {

    private static final Logger LOGGER = Logger.getLogger(DB.class);

    private static final String CREATE_TABLE_IMPRESORA = "DROP TABLE IF EXISTS IMPRESORA;" +
            "CREATE TABLE IMPRESORA (" +
            "ID INT AUTO_INCREMENT PRIMARY KEY," +
            "NOMBRE VARCHAR(50)," +
            "MARCA VARCHAR(50)," +
            "COLOR VARCHAR(50)" +
            ")";

    public static void crearTabla(){
        Connection con = null;
        try{
            con = getConnection();
            Statement stm = con.createStatement();
            stm.execute(CREATE_TABLE_IMPRESORA);

        }
        catch (Exception e){
            LOGGER.error("La tabla no pudo ser creada: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("Conexion al crear tabla no pudo ser cerrada: " + e.getMessage());
            }
        }
    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clase14EjercicioExtra","sa","sa");
    }
}
