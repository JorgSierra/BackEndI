package com.dh.clase23.service;

import com.dh.clase23.dao.Idao;
import com.dh.clase23.dao.PacienteDAOH2;
import com.dh.clase23.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
    public Paciente buscarPacienteEmail (String email) { return  pacienteIDao.searchString(email);}
}
