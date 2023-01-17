package dao;

public interface Idao <T>{
    T registrar (T t);
    void eliminar (Integer id);
    T buscarPorId  (Integer id);
}
