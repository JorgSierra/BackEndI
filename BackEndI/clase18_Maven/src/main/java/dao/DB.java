package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {
    private static final Logger LOGGER = Logger.getLogger(DB.class);
    private static final String SQL_DROP_CREATE_ODONTOLOGO = "DROP TABLE IF EXISTS ODONTOLOGO;" +
            "CREATE TABLE ODONTOLOGO " +
            "(ID INT AUTO_INCREMENT PRIMARY KEY," +
            " MATRICULA VARCHAR(50) NOT NULL," +
            " NOMBRE VARCHAR (50) NOT NULL," +
            " APELLIDO VARCHAR(50) NOT NULL" +
            ")";
    private static final String SQL_DROP_CREATE_PACIENTE = "DROP TABLE IF EXISTS PACIENTE; " +
            "CREATE TABLE PACIENTE " +
            "(ID INT AUTO_INCREMENT PRIMARY KEY," +
            " NOMBRE VARCHAR(50) NOT NULL," +
            " APELLIDO VARCHAR (50) NOT NULL," +
            " DNI VARCHAR(50) NOT NULL," +
            " FECHA_INGRESO DATE NOT NULL," +
            " DOMICILIO_ID INT NOT NULL)";
    private static final String SQL_DROP_CREATE_DOMICILIO = "DROP TABLE IF EXISTS DOMICILIO; " +
            "CREATE TABLE DOMICILIO " +
            "(ID INT AUTO_INCREMENT PRIMARY KEY," +
            " CALLE VARCHAR(50) NOT NULL," +
            " NUMERO INT NOT NULL," +
            " LOCALIDAD VARCHAR(50) NOT NULL," +
            " PROVINCIA VARCHAR(50) NOT NULL" +
            ")";
    public static Connection getConnection() throws  Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/SIERRA_JORGE","sa","sa");
    }

    public static void dropCreateTables(){
        LOGGER.info("Creating tables ...");
        Connection con = null;
        try {
            con = getConnection();
            Statement stm = con.createStatement();
            stm.execute(SQL_DROP_CREATE_ODONTOLOGO);
            stm.execute(SQL_DROP_CREATE_PACIENTE);
            stm.execute(SQL_DROP_CREATE_DOMICILIO);
        }
        catch (Exception e){
            LOGGER.error("Table creation failed: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("Close connection on table creation failed: " + e.getMessage());
            }
        }
        LOGGER.warn("Tables created");
    }
}
