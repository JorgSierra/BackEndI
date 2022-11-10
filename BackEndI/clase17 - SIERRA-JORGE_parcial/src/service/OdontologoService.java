package service;

import dao.IDao;
import dao.OdontologoDAOH2;
import model.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService() {
        this.odontologoIDao = new OdontologoDAOH2();
    }

    public Odontologo guardarOdontologo (Odontologo odon){
        return odontologoIDao.guardar(odon);
    }

    public List<Odontologo> buscarTodosOdontologos(){
        return odontologoIDao.buscarTodo();
    }
}
