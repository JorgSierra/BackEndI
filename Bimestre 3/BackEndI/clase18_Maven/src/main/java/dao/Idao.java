package dao;

import java.util.List;

public interface Idao<T> {
    // Modifiers
    T save (T t);
    void update (T t);
    void delete (Integer id);

    // Searches
    T searchID (Integer id);
    List<T> search ();
}
