package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements Idao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGO (MATRICULA, NOMBRE, APELLIDO) " +
            "VALUES (?,?,?);";
    private static final String SQL_UPDATE = "UPDATE ODONTOLOGO SET MATRICULA = ?, NOMBRE = ?, APELLIDO = ? WHERE ID = ?;";
    private static final String SQL_DELETE = "DELETE FROM ODONTOLOGO WHERE ID = ?;";
    private static final String SQL_SELECT = "SELECT * FROM ODONTOLOGO WHERE ID = ?;";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGO;";
    @Override
    public Odontologo save (Odontologo odontologo) {
        LOGGER.info("Saving odontologo ...");
        Connection con = null;
        try {
            con = DB.getConnection();
            PreparedStatement pStm = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            pStm.setString(1,odontologo.getMatricula());
            pStm.setString(2,odontologo.getNombre());
            pStm.setString(3,odontologo.getApellido());
            pStm.execute();

            ResultSet rs = pStm.getGeneratedKeys();
            while (rs.next()){
                odontologo.setID(rs.getInt(1));
            }
            LOGGER.info("Odontologo saved");
        }
        catch (Exception e){
            LOGGER.error("Saving odontologo failed: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("Connection closing during odontologo saving failed: " + e.getMessage());
            }
        }
        return odontologo;
    }

    @Override
    public void update (Odontologo odontologo) {
        LOGGER.warn("Updating odontologo ID: " + odontologo.getID() + " ...");
        Connection con = null;
        try {
            con = DB.getConnection();
            PreparedStatement pStm = con.prepareStatement(SQL_UPDATE);
            pStm.setString(1, odontologo.getMatricula());
            pStm.setString(2, odontologo.getNombre());
            pStm.setString(3, odontologo.getApellido());
            pStm.setInt(4, odontologo.getID());
            pStm.execute();

            LOGGER.warn("Odontologo with ID: " + odontologo.getID() + " was successfully updated!");
        }
        catch (Exception e){
            LOGGER.error("Updating odontologo failed " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("Connection closing during odontologo update failed: " + e.getMessage());
            }
        }
    }

    @Override
    public void delete (Integer id) {
        LOGGER.warn("Deleting odontologo ID: " + id + " ...");
        Connection con = null;
        try {
            con = DB.getConnection();
            PreparedStatement pStm = con.prepareStatement(SQL_DELETE);
            pStm.setInt(1, id);
            pStm.execute();

            LOGGER.warn("Odontologo with ID: " + id + " was successfully deleted!");
        }
        catch (Exception e){
            LOGGER.error("Deleting odontologo failed " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("Connection closing during odontologo deletion failed: " + e.getMessage());
            }
        }
    }

    @Override
    public Odontologo searchID (Integer id) {
        LOGGER.info("Searching odontologo ...");
        Connection con = null;
        Odontologo odontologo = null;
        try {
            con = DB.getConnection();
            PreparedStatement pStm = con.prepareStatement(SQL_SELECT);
            pStm.setInt(1, id);
            ResultSet rs = pStm.executeQuery();
            while (rs.next()){
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            LOGGER.info("Odontologo found");
        }
        catch (Exception e){
            LOGGER.error("Odontologo ID search failed " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("Connection closing during odontologo search failed: " + e.getMessage());
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> search () {
        LOGGER.info("Getting odontologo list ...");
        Connection con = null;
        Odontologo aux = null;
        List<Odontologo> odontologoList = new ArrayList<>();

        try {
            con = DB.getConnection();
            PreparedStatement pStm = con.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = pStm.executeQuery();
            while (rs.next()){
                aux = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
                odontologoList.add(aux);
            }
            LOGGER.info("Odontologo list found");
        }
        catch (Exception e){
            LOGGER.error("Odontologo list search failed " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("Connection closing during odontologo list search failed: " + e.getMessage());
            }
        }
        return odontologoList;
    }
}