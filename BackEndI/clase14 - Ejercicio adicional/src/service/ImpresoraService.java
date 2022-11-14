package service;

import dao.Idao;
import dao.ImpresoraDAOH2;
import model.Impresora;

public class ImpresoraService {
    Idao<Impresora> impresoraIdao;

    public ImpresoraService() {
        this.impresoraIdao = new ImpresoraDAOH2();
    }

    public Impresora registrar(Impresora i){
        return impresoraIdao.registrar(i);
    }

    public void eliminar(Integer id){
        impresoraIdao.eliminar(id);
    }

    public Impresora buscar(Integer id){
        return impresoraIdao.buscarPorId(id);
    }
}
