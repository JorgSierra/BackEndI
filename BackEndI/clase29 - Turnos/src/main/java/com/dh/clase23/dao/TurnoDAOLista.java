package com.dh.clase23.dao;

import com.dh.clase23.model.Turno;

import java.util.ArrayList;
import java.util.List;

public class TurnoDAOLista implements Idao<Turno> {
    private List<Turno> turnosDB = new ArrayList<>();
    @Override
    public Turno save(Turno turno) {
        turnosDB.add(turno);
        return turno;
    }

    @Override
    public void update(Turno turno) {
        delete(turno.getId());
        save(turno);
    }

    @Override
    public void delete(Integer id) {
        Turno delete = searchID(id);
        if (delete != null){
            turnosDB.remove(delete);
        }
    }

    @Override
    public Turno searchID(Integer id) {
        for (Turno turno:
             turnosDB) {
            if (turno.getId().equals(id)){
                return turno;
            }
        }
        return null;
    }

    @Override
    public List<Turno> search() {
        return turnosDB;
    }

    @Override
    public Turno searchString(String value) {
        return null;
    }
}
