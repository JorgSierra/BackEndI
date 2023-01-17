package service;

import dao.Idao;
import dao.PacienteDAOH2;
import model.Paciente;

import java.util.List;

public class PacienteService {
    private Idao<Paciente> pacienteIDao;

    public PacienteService() {
        this.pacienteIDao = new PacienteDAOH2();
    }
    public Paciente guardarPaciente (Paciente paciente){
        return pacienteIDao.save(paciente);
    }
    public void modificarPaciente (Paciente paciente){
        pacienteIDao.update(paciente);
    }
    public void eliminarPaciente (Integer id){
        pacienteIDao.delete(id);
    }
    public Paciente buscarPacienteID (Integer id){
        return pacienteIDao.searchID(id);
    }
    public List<Paciente> listarPacientes(){
        return pacienteIDao.search();
    }
}
