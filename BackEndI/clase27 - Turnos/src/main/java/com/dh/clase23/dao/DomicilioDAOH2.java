package com.dh.clase23.dao;

import com.dh.clase23.model.Domicilio;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDAOH2 implements Idao<Domicilio>{
    private static final Logger LOGGER = Logger.getLogger(DomicilioDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO DOMICILIO (CALLE, NUMERO, LOCALIDAD, PROVINCIA) " +
            "VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE DOMICILIO SET CALLE = ?, NUMERO = ?, LOCALIDAD = ?, PROVINCIA = ? WHERE ID=?;";
    private static final String SQL_DELETE = "DELETE FROM DOMICILIO WHERE ID = ?;";
    private static final String SQL_SELECT = "SELECT * FROM DOMICILIO WHERE ID = ?;";
    private static final String SQL_SELECT_ALL="SELECT * FROM DOMICILIO;";
    @Override
    public Domicilio save (Domicilio domicilio) {
        LOGGER.info("Saving domicilio ...");
        Connection con = null;
        try{
            con = DB.getConnection();
            PreparedStatement pStm = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            pStm.setString(1,domicilio.getCalle());
            pStm.setInt(2,domicilio.getNumero());
            pStm.setString(3, domicilio.getLocalidad());
            pStm.setString(4, domicilio.getProvincia());
            pStm.execute();

            ResultSet rs = pStm.getGeneratedKeys();
            while(rs.next()){
                domicilio.setID(rs.getInt(1));
            }
            LOGGER.info("Domicilio saved");
        }
        catch (Exception e){
            LOGGER.error("Saving domicilio failed: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }
            catch (SQLException e){
                LOGGER.error("Connection closing during domicilio saving failed: " + e.getMessage());
            }
        }
        return domicilio;
    }

    @Override
    public void update (Domicilio domicilio) {
        LOGGER.warn("Updating domicilio ID: " + domicilio.getID() + " ...");
        Connection con = null;
        try{
            con = DB.getConnection();
            PreparedStatement pStm = con.prepareStatement(SQL_UPDATE);
            pStm.setString(1, domicilio.getCalle());
            pStm.setInt(2,domicilio.getNumero());
            pStm.setString(3, domicilio.getLocalidad());
            pStm.setString(4, domicilio.getProvincia());
            pStm.setInt(5,domicilio.getID());
            pStm.execute();

            LOGGER.warn("Domicilio with ID: " + domicilio.getID() + " was successfully updated!");
        }
        catch (Exception e){
            LOGGER.error("Updating domicilio failed " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }
            catch (SQLException e){
                LOGGER.error("Connection closing during domicilio update failed: " + e.getMessage());
            }
        }
    }

    @Override
    public void delete (Integer id) {
        LOGGER.warn("Deleting domicilio ID: " + id + " ...");
        Connection con = null;
        try{
            con = DB.getConnection();
            PreparedStatement pStm = con.prepareStatement(SQL_DELETE);
            pStm.setInt(1,id);
            pStm.execute();

            LOGGER.warn("Domicilio with ID: " + id + " was successfully deleted!");
        }
        catch (Exception e){
            LOGGER.error("Deleting domicilio failed " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }
            catch (SQLException e){
                LOGGER.error("Connection closing during domicilio deletion failed: " + e.getMessage());
            }
        }
    }

    @Override
    public Domicilio searchID (Integer id){
        LOGGER.info("Searching domicilio ...");
        Connection con = null;
        Domicilio domicilio = null;
        try{
            con = DB.getConnection();
            PreparedStatement pStm = con.prepareStatement(SQL_SELECT);
            pStm.setInt(1,id);
            ResultSet rs = pStm.executeQuery();
            while(rs.next()){
                domicilio=new Domicilio(rs.getInt(1),rs.getString(2), rs.getInt(3),rs.getString(4),rs.getString(5));
            }
            LOGGER.info("Domicilio found");
        }
        catch (Exception e){
            LOGGER.error("Domicilio ID search failed " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }
            catch (SQLException e){
                LOGGER.error("Connection closing during domicilio search failed: " + e.getMessage());
            }
        }
        return domicilio;
    }

    @Override
    public List<Domicilio> search () {
        LOGGER.info("Getting domicilio list ...");
        Connection con = null;
        List<Domicilio> domicilios= new ArrayList<>();
        Domicilio aux = null;
        try{
            con = DB.getConnection();
            PreparedStatement pSmt = con.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = pSmt.executeQuery();
            while(rs.next()){
                aux = new Domicilio(rs.getInt(1),rs.getString(2),
                        rs.getInt(3),rs.getString(4),rs.getString(5));
                domicilios.add(aux);
            }
            LOGGER.info("Domicilio list found");
        }
        catch (Exception e){
            LOGGER.error("Domicilio list search failed " + e.getMessage());
        }
        finally {
            try{
                con.close();
            }
            catch (SQLException e){
                LOGGER.error("Connection closing during domicilio list search failed: " + e.getMessage());
            }
        }
        return domicilios;
    }

    @Override
    public Domicilio searchString(String value) {
        return null;
    }
}