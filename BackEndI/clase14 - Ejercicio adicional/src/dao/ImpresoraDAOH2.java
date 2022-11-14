package dao;

import model.Impresora;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ImpresoraDAOH2 implements Idao<Impresora> {

    private static final Logger LOGGER = Logger.getLogger(ImpresoraDAOH2.class);
    private static final String SELECT_BY_ID = "SELECT * FROM IMPRESORA WHERE ID = ?";
    private static final String INSERT = "INSERT INTO IMPRESORA " +
            "(NOMBRE, MARCA, COLOR)" +
            "VALUES (?,?,?);";
    private static final String DELETE = "DELETE FROM IMPRESORA WHERE ID = ?";
    @Override
    public Impresora registrar(Impresora impresora) {
        LOGGER.info("Intentando registrar nueva impresora ...");
        Connection con = null;
        try {
            con = DB.getConnection();
            PreparedStatement pStm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pStm.setString(1, impresora.getNombre());
            pStm.setString(2, impresora.getMarca());
            pStm.setString(3, impresora.getColor());
            pStm.execute();

            ResultSet rs = pStm.getGeneratedKeys();
            while (rs.next()){
                impresora.setID(rs.getInt(1));
            }
        }
        catch (Exception e){
            LOGGER.error("No se pudo registrar impresora " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("No se pudo cerrar conexion de registro " + e.getMessage());
            }
        }
        LOGGER.info("Impresora registrada con exito!");
        return impresora;
    }

    @Override
    public void eliminar(Integer id) {
        LOGGER.warn("Intentando eliminar una impresora ...");
        Connection con = null;
        try {
            con = DB.getConnection();
            PreparedStatement pStm = con.prepareStatement(DELETE);
            pStm.setInt(1, id);
            pStm.execute();

            LOGGER.warn("Impresora con ID: " + id + " fue eliminada con exito!");
        }
        catch (Exception e){
            LOGGER.error("No se pudo eliminar impresora " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("No se pudo cerrar la conexion de eliminar " + e.getMessage());
            }
        }
    }

    @Override
    public Impresora buscarPorId(Integer id) {
        LOGGER.info("Buscando impresora ...");
        Connection con = null;
        Impresora impresora = null;
        try {
            con = DB.getConnection();
            PreparedStatement pSmt = con.prepareStatement(SELECT_BY_ID);
            pSmt.setInt(1, id);
            ResultSet rs = pSmt.executeQuery();
            while (rs.next()){
                impresora = new Impresora(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        }
        catch (Exception e){
            LOGGER.error("No se encuentra la impresora " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }
            catch (Exception e){
                LOGGER.error("No se pudo cerrar la conexion de busqueda " + e.getMessage());
            }
        }
        return impresora;
    }
}
