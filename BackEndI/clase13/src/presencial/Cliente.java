package presencial;

import java.sql.*;

public class Cliente {
    private static final String SQL_DROP_CREATE="DROP TABLE IF EXISTS CUENTAS;" +
            "CREATE TABLE CUENTAS (" +
            "ID INT PRIMARY KEY," +
            "NUMERO_CUENTA INT NOT NULL," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "SALDO NUMERIC(10,2) NOT NULL" +
            ")";
    // NUMERIC(10,2)-> NÚMERO DE 10 DÍGITOS RESERVANDO 2 PARA DECIMAL EJ:12345678,91
    private static final String SQL_INSERT="INSERT INTO CUENTAS VALUES (?,?,?,?)";
    private static final String SQL_UPDATE_SALDO="UPDATE CUENTAS SET SALDO=? WHERE ID=?";
    private static final String SQL_SELECT="SELECT * FROM CUENTAS";
    public static void main(String[] args) {
        Connection connection=null;
        try{
            //primero nos conectamos
            connection=getConnection();
            Statement statement= connection.createStatement();
            //preparar la tabla cuentas
            statement.execute(SQL_DROP_CREATE);
            //insertar un elemento a la tabla
            PreparedStatement psInsert=connection.prepareStatement(SQL_INSERT);
            //completar el psInsert
            psInsert.setInt(1,1);
            psInsert.setInt(2,98574);
            psInsert.setString(3,"Rodolfo");
            psInsert.setDouble(4,258);
            psInsert.execute();

            ResultSet rs= statement.executeQuery(SQL_SELECT);
            while (rs.next()){
                System.out.println("ID: "+rs.getInt(1)+
                        " - Nombre: "+rs.getString(3)+
                        " - Saldo: "+rs.getDouble(4));
            }


            //aumentar el saldo en +10
            PreparedStatement psUpdate=connection.prepareStatement(SQL_UPDATE_SALDO);
            psUpdate.setDouble(1,258+10);
            psUpdate.setInt(2,1);
            psUpdate.execute();

            rs= statement.executeQuery(SQL_SELECT);
            while (rs.next()){
                System.out.println("ID: "+rs.getInt(1)+
                        " - Nombre: "+rs.getString(3)+
                        " - Saldo: "+rs.getDouble(4));
            }

            //transacción
            connection.setAutoCommit(false);
            PreparedStatement psUpdate2=connection.prepareStatement(SQL_UPDATE_SALDO);
            psUpdate2.setDouble(1,258+10+15);
            psUpdate2.setInt(2,1);
            //esta bien y por ende procedemos a realizar el commit
            psUpdate2.execute();
            int a=4/0;
            connection.commit();
            //buena costumbre
            connection.setAutoCommit(true);

            //aumentar el saldo en +15 pero con un error
        }
        catch (Exception e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        //vamos a ver como quedo la base
        try{
            //primero nos conectamos
            connection=getConnection();
            Statement statement= connection.createStatement();
            ResultSet rs= statement.executeQuery(SQL_SELECT);
            while (rs.next()){
                System.out.println("ID: "+rs.getInt(1)+
                        " - Nombre: "+rs.getString(3)+
                        " - Saldo: "+rs.getDouble(4));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/c3clase13",
                "sa","sa");
    }
}
