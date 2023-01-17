import org.apache.log4j.Logger;

import java.sql.*;

public class Empresa {
    //preparamos los SQL, en este caso nos encontramos con una tabla de empleados
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS EMPLEADOS; CREATE TABLE EMPLEADOS "
            + "("
            + " ID INT PRIMARY KEY,"
            + " PRIMER_NOMBRE VARCHAR(100) NOT NULL, "
            + " APELLIDO VARCHAR(100) NOT NULL, "
            + " SIGNO VARCHAR(100) NOT NULL,"
            + " EDAD INT NOT NULL"
            + " )";

    private static final String SQL_INSERT_ERROR =  "INSERT INTO EMPLEADOS VALUES (1, 'Lia', 'Luz','Cancer', 55)," +
            "(2, 'Lore', 'Ga','Tauro', 18),(1, 'Peter', 'Perez','Escorpio', 75)";
    private static final String SQL_INSERT_OK =  "INSERT INTO EMPLEADOS VALUES (1, 'Lia', 'Luz','Cancer', 55)," +
            "(2, 'Lore', 'Ga','Tauro', 18),(3, 'Peter', 'Perez','Escorpio', 75)";

    private static final String SQL_DELETE_ID =  "DELETE FROM EMPLEADOS WHERE ID=3";
    private static final String SQL_DELETE_EDAD =  "DELETE FROM EMPLEADOS WHERE EDAD=18";
    private static final String SQL_UPDATE = "UPDATE EMPLEADOS SET EDAD=25 WHERE ID=1";
    private static final String SQL_SELECT_ID_1 = "SELECT * FROM EMPLEADOS WHERE ID=1";
    private static final String SQL_SELECT_ID_3 = "SELECT * FROM EMPLEADOS WHERE ID=3";
    private static final String SQL_SELECT =  "SELECT * FROM EMPLEADOS";

    private static final Logger LOGGER = Logger.getLogger(Empresa.class);

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            statement.execute(SQL_INSERT_ERROR);
        }
        catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_INSERT_OK);
            statement.execute(SQL_UPDATE);

            ResultSet rs = statement.executeQuery(SQL_SELECT_ID_1);
            while (rs.next()){
                LOGGER.debug("Empleada/o actualizada/o - ID: "+rs.getInt(1)
                        +" - nombre: "+rs.getString(2)
                        +" - apellido: "+rs.getString(3)
                        +" - signo: "+rs.getString(4)
                        +" - edad: "+rs.getInt(5));
            }

            rs = statement.executeQuery(SQL_SELECT_ID_3);
            while (rs.next()){
                LOGGER.info("Empleada/o eliminada/o - ID: "+rs.getInt(1)
                        +" - nombre: "+rs.getString(2)
                        +" - apellido: "+rs.getString(3)
                        +" - signo: "+rs.getString(4)
                        +" - edad: "+rs.getInt(5));
            }

            statement.execute(SQL_DELETE_ID);
            rs = statement.executeQuery(SQL_SELECT);
            while (rs.next()){
                LOGGER.info("Empleada/o eliminada/o - ID: "+rs.getInt(1)
                        +" - nombre: "+rs.getString(2)
                        +" - apellido: "+rs.getString(3)
                        +" - signo: "+rs.getString(4)
                        +" - edad: "+rs.getInt(5));
            }

            statement.execute(SQL_DELETE_EDAD);
            System.out.println("**************************************");
            System.out.println("ADICIONAL - ESTADO DE LA TABLA");
            rs = statement.executeQuery(SQL_SELECT);
            while (rs.next()){
                System.out.println("ID: "+rs.getInt(1)
                        +" - nombre: "+rs.getString(2)
                        +" - apellido: "+rs.getString(3)
                        +" - signo: "+rs.getString(4)
                        +" - edad: "+rs.getInt(5));
            }
        }
        catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clase12mesas","sa","sa");
    }
}
