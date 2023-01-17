package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS VALUES (?,?,?,?);";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS";
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection con = null;
        try {
            con = DB.getConnection();
            LOGGER.info("Inicio de una operación de guardar odontologo");
            PreparedStatement psInsert = con.prepareStatement(SQL_INSERT);
            psInsert.setInt(1,odontologo.getId());
            psInsert.setString(2,odontologo.getMatricula());
            psInsert.setString(3,odontologo.getNombre());
            psInsert.setString(4,odontologo.getApellido());
            psInsert.execute();
            LOGGER.warn("El odontologo fue insertado en la tabla");
        }
        catch (Exception e){
            LOGGER.error("No se pudo guardar odontologo " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("No se pudo cerrar la coneccion " + e.getMessage());
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodo() {
        Connection con = null;
        List<Odontologo> odontologoList = new ArrayList<>();
        Odontologo aux = null;
        try {
            con = DB.getConnection();
            LOGGER.info("Inicio de una operación de busqueda de todos los odontologos");
            PreparedStatement psGetAll = con.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = psGetAll.executeQuery();
            while (rs.next()){
                aux = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
                odontologoList.add(aux);
            }

        }
        catch (Exception e){
            LOGGER.error("No se pudo realizar busqueda " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("No se pudo cerrar la coneccion " + e.getMessage());
            }
        }
        return odontologoList;
    }
}
