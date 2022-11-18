package dao;

import model.Domicilio;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOH2 implements Idao<Paciente>{
    private static final Logger LOGGER= Logger.getLogger(PacienteDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO PACIENTE (NOMBRE, APELLIDO, DNI, FECHA_INGRESO, DOMICILIO_ID) VALUES (?, ?, ?, ?, ?);";
    private static final String SQL_UPDATE = "UPDATE PACIENTE SET NOMBRE = ?, APELLIDO = ?, DNI = ?, FECHA_INGRESO = ?, DOMICILIO_ID = ? WHERE ID = ?;";
    private static final String SQL_DELETE = "DELETE FROM PACIENTE WHERE ID = ?;";
    private static final String SQL_SELECT="SELECT * FROM PACIENTE WHERE ID = ?;";
    private static final String SQL_SELECT_ALL = "SELECT * FROM PACIENTE;";
    @Override
    public Paciente save(Paciente paciente) {
        LOGGER.info("Saving paciente ...");
        Connection con = null;
        DomicilioDAOH2 domAux = new DomicilioDAOH2();
        try {
            con = DB.getConnection();
            paciente.setDomicilio(domAux.save(paciente.getDomicilio()));
            PreparedStatement pStm = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            pStm.setString(1, paciente.getNombre());
            pStm.setString(2, paciente.getApellido());
            pStm.setString(3, paciente.getDni());
            pStm.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            pStm.setInt(5, paciente.getDomicilio().getID());
            pStm.execute();

            ResultSet rs = pStm.getGeneratedKeys();
            while (rs.next()){
                paciente.setID(rs.getInt(1));
            }
            LOGGER.info("Paciente saved");
        }
        catch (Exception e){
            LOGGER.error("Saving paciente failed: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("Connection closing during paciente saving failed: " + e.getMessage());
            }
        }
        return paciente;
    }

    @Override
    public void update(Paciente paciente) {
        LOGGER.warn("Updating paciente ID: " + paciente.getID() + " ...");
        Connection con = null;
        DomicilioDAOH2 domAux = new DomicilioDAOH2();
        try {
            con = DB.getConnection();
            Integer domicilioID = searchID(paciente.getID()).getDomicilio().getID();
            paciente.getDomicilio().setID(domicilioID);
            domAux.update(paciente.getDomicilio());
            PreparedStatement pStm = con.prepareStatement(SQL_UPDATE);
            pStm.setString(1, paciente.getNombre());
            pStm.setString(2, paciente.getApellido());
            pStm.setString(3, paciente.getDni());
            pStm.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            pStm.setInt(5, domicilioID);
            pStm.setInt(6, paciente.getID());
            pStm.execute();

            LOGGER.warn("Paciente with ID: " + paciente.getID() + " was successfully updated!");
        }
        catch (Exception e){
            LOGGER.error("Updating paciente failed " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("Connection closing during paciente update failed: " + e.getMessage());
            }
        }
    }

    @Override
    public void delete(Integer id) {
        LOGGER.warn("Deleting paciente ID: " + id + " ...");
        Connection con = null;
        DomicilioDAOH2 domAux = new DomicilioDAOH2();
        try {
            con = DB.getConnection();
            domAux.delete(searchID(id).getDomicilio().getID());
            PreparedStatement pStm = con.prepareStatement(SQL_DELETE);
            pStm.setInt(1, id);
            pStm.execute();

            LOGGER.warn("Paciente with ID: " + id + " was successfully deleted!");
        }
        catch (Exception e){
            LOGGER.error("Deleting paciente failed " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("Connection closing during paciente deletion failed: " + e.getMessage());
            }
        }
    }

    @Override
    public Paciente searchID(Integer id) {
        LOGGER.info("Searching paciente ...");
        Connection con = null;
        Paciente paciente = null;
        try{
            con = DB.getConnection();
            PreparedStatement pStm = con.prepareStatement(SQL_SELECT);
            pStm.setInt(1, id);
            ResultSet rs = pStm.executeQuery();
            DomicilioDAOH2 domAux = new DomicilioDAOH2();
            while (rs.next()){
                Domicilio domicilio = domAux.searchID(rs.getInt(6));
                paciente = new Paciente(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getDate(5).toLocalDate(), domicilio);
            }
            LOGGER.info("Paciente found");
        }
        catch (Exception e){
            LOGGER.error("Paciente ID search failed " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }
            catch (SQLException e){
                LOGGER.error("Connection closing during paciente search failed: " + e.getMessage());
            }
        }
        return  paciente;
    }

    @Override
    public List<Paciente> search() {
        LOGGER.info("Getting paciente list ...");
        Connection con = null;
        Paciente aux = null;
        List<Paciente> pacienteList = new ArrayList<>();
        DomicilioDAOH2 domAux = new DomicilioDAOH2();
        try {
            con = DB.getConnection();
            PreparedStatement pStm = con.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = pStm.executeQuery();
            while (rs.next()){
                Domicilio domicilio = domAux.searchID(rs.getInt(6));
                aux = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5).toLocalDate(), domicilio);
                pacienteList.add(aux);
            }
            LOGGER.info("Paciente list found");
        }
        catch (Exception e){
            LOGGER.error("Paciente list search failed " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("Connection closing during paciente list search failed: " + e.getMessage());
            }
        }
        return pacienteList;
    }
}
