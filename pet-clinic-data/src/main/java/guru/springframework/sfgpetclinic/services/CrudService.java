package guru.springframework.sfgpetclinic.services;

import java.util.Set;

/**
 * Created by Ricardo Vargas on 6/08/19.
 */
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
