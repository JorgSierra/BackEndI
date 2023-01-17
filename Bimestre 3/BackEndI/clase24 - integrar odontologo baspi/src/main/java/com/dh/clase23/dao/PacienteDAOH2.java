package com.dh.clase23.dao;

import com.dh.clase23.model.Paciente;
import com.dh.clase23.model.Domicilio;
import com.dh.clase23.model.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente>{
    private static final Logger LOGGER= Logger.getLogger(PacienteDAOH2.class);
    private static final String SQL_SELECT="SELECT * FROM PACIENTES WHERE ID=?";
    private static final String SQL_SELECT_ALL="SELECT * FROM PACIENTES";
    private static final String SQL_UPDATE="UPDATE PACIENTES SET NOMBRE=?," +
            "APELLIDO=?,DNI=?,FECHA_INGRESO=?,DOMICILIO_ID=?,EMAIL=? WHERE ID=?";
    private static final String SQL_SELECT_BY_EMAIL="SELECT * FROM PACIENTES WHERE EMAIL=?";
    @Override
    public Paciente guardar(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente buscar(Integer id) {
        Connection connection=null;
        LOGGER.info("Iniciando la busqueda del paciente con id="+id);
        Paciente paciente=null;
        try{
            connection=BD.getConnection();
            PreparedStatement psSelect=connection.prepareStatement(SQL_SELECT);
            psSelect.setInt(1,id);
            ResultSet rs= psSelect.executeQuery();
            //Recordar que || Tabla Paciente -> 1,Rodolfo,Baspineiro, 584, 02-11-2022,15(fk)
            DomicilioDAOH2 daoAux= new DomicilioDAOH2();
            while (rs.next()){
                Domicilio domicilio= daoAux.buscar(rs.getInt(6));
                paciente=new Paciente(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),
                        rs.getDate(5).toLocalDate(),domicilio,rs.getString(7));
                //LocalDate fecha= LocalDate.of(2022,11,1);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return  paciente;
    }

    @Override
    public void actualizar(Paciente paciente) {
        Connection connection=null;
        LOGGER.info("Iniciando la actualización del paciente con id="+paciente.getId());
        try{
            connection=BD.getConnection();
            DomicilioDAOH2 daoAux= new DomicilioDAOH2();
            //se encarga de actualizar los datos del domicilio
            daoAux.actualizar(paciente.getDomicilio());
            PreparedStatement psUpdate=connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1,paciente.getNombre());
            psUpdate.setString(2, paciente.getApellido());
            psUpdate.setString(3, paciente.getDni());
            psUpdate.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            psUpdate.setInt(5,paciente.getDomicilio().getId());
            psUpdate.setString(6, paciente.getEmail());
            psUpdate.setInt(7,paciente.getId());
            psUpdate.execute();
            //Recordar que || Tabla Paciente -> 1,Rodolfo,Baspineiro, 584, 02-11-2022,15(fk)
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Paciente> buscarTodo() {
        Connection connection=null;
        LOGGER.info("Iniciando la busqueda de los pacientes");
        Paciente paciente=null;
        List<Paciente> listaPacientes=new ArrayList<>();
        try{
            connection=BD.getConnection();
            PreparedStatement psSelect=connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs= psSelect.executeQuery();
            //Recordar que || Tabla Paciente -> 1,Rodolfo,Baspineiro, 584, 02-11-2022,15(fk)
            DomicilioDAOH2 daoAux= new DomicilioDAOH2();
            while (rs.next()){
                Domicilio domicilio= daoAux.buscar(rs.getInt(6));
                paciente=new Paciente(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),
                        rs.getDate(5).toLocalDate(),domicilio,rs.getString(7));
                listaPacientes.add(paciente);
                //LocalDate fecha= LocalDate.of(2022,11,1);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return listaPacientes;
    }

    @Override
    public Paciente buscarXString(String valor) {
        Connection connection=null;
        LOGGER.info("Iniciando la busqueda del paciente con email="+valor);
        Paciente paciente=null;
        try{
            connection=BD.getConnection();
            PreparedStatement psSelect=connection.prepareStatement(SQL_SELECT_BY_EMAIL);
            psSelect.setString(1,valor);
            ResultSet rs= psSelect.executeQuery();
            //Recordar que || Tabla Paciente -> 1,Rodolfo,Baspineiro, 584, 02-11-2022,15(fk)
            DomicilioDAOH2 daoAux= new DomicilioDAOH2();
            while (rs.next()){
                Domicilio domicilio= daoAux.buscar(rs.getInt(6));
                paciente=new Paciente(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),
                        rs.getDate(5).toLocalDate(),domicilio,rs.getString(7));
                //LocalDate fecha= LocalDate.of(2022,11,1);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return  paciente;
    }
}
