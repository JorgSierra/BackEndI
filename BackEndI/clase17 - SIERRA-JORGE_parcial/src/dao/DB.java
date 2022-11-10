package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {

    private static final Logger LOGGER = Logger.getLogger(DB.class);

    private static final String SQL_DROP_CREATE = "DROP TABLE IF EXISTS ODONTOLOGOS;" +
            "CREATE TABLE ODONTOLOGOS (ID INT PRIMARY KEY," +
            " MATRICULA VARCHAR(100) NOT NULL," +
            " NOMBRE VARCHAR (100) NOT NULL," +
            " APELLIDO VARCHAR(100) NOT NULL" +
            ")";

    public static Connection getConnection() throws  Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/SIERRA-JORGE_parcial","sa","sa");
    }

    public static void crearTabla(){
        Connection con = null;
        try {
            con = getConnection();
            Statement stmt = con.createStatement();
            LOGGER.info("Iniciando la creación de tabla");
            stmt.execute(SQL_DROP_CREATE);
            LOGGER.warn("Tabla creada");
        }
        catch (Exception e){
            LOGGER.error("No pudo ser realizada la creacion de tablas " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("No se pudo cerrar la coneccion " + e.getMessage());
            }
        }
    }
}
