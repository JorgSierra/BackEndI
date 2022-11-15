package service;


import dao.Idao;
import dao.OdontologoDAOH2;
import model.Odontologo;

import java.util.List;

public class OdontologoService {
    private Idao<Odontologo> odontologoIDao;

    public OdontologoService() {
        this.odontologoIDao = new OdontologoDAOH2();
    }

    public Odontologo guardarOdontologo (Odontologo odontologo){
        return odontologoIDao.save(odontologo);
    }

    public void modificarOdontologo (Odontologo odontologo){
        odontologoIDao.update(odontologo);
    }

    public void eliminarOdontologo (Integer id){
        odontologoIDao.delete(id);
    }

    public Odontologo buscarOdontologoID (Integer id){
        return odontologoIDao.searchID(id);
    }

    public List<Odontologo> listarOdontologos(){
        return odontologoIDao.search();
    }
}
