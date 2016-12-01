package br.com.cwi.cadastrodefilmesdao;

import javax.persistence.EntityManager;

/**
 * @author Carlos H. Nonnemacher
 * @param <T>
 * @param <ID>
 *
 */
public abstract class AbstractFilmeDao<T, B, C, ID> implements IDao<T, ID> {

    public abstract EntityManager getEntityManager();

    private final Class<T> clazz;
    private final Class<B> clezz;
    private final Class<C> clizz;

    public AbstractFilmeDao(Class<T> clazz, Class<B> clezz, Class<C> clizz) {
        this.clazz = clazz;
        this.clezz = clezz;
        this.clizz = clizz;
    }

    @Override
    public void insert(T t) {
        this.getEntityManager().merge(t);
    }
    
    public void insert2(T t, B b, C c) {
        this.getEntityManager().merge(t);
        this.getEntityManager().merge(b);
        this.getEntityManager().merge(c);
    }

    @Override
    public void delete(T t) {
        this.getEntityManager().remove(t);
    }

    @Override
    public T find(ID id) {
        return this.getEntityManager().find(clazz, id);
    }

}