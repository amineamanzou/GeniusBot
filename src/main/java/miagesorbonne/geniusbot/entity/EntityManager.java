package miagesorbonne.geniusbot.entity;

import java.util.List;

/**
 * Entity manager interface
 * 
 * @author Amanzou Amine <amineamanzou@gmail.com>
 * @param <E>
 */
public interface EntityManager<E extends Entity> {
    
    E findById(Integer id) throws NoSuchEntityException;
    void save(E entity) throws NoSuchEntityException;
    void remove(E entity) throws NoSuchEntityException;
    List<E> findAll();
    
}
