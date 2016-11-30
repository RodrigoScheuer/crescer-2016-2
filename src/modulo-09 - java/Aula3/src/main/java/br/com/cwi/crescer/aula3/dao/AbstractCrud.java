/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author Rodrigo
 * @param <T>
 * @param <ID>
 */
public abstract class AbstractCrud<T, ID> implements ICrudDao<T, ID> {

    public abstract EntityManager getEntityManager();

    private final Class<T> clazz;

    public AbstractCrud(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void insert(T t) {
        try {
            this.getEntityManager().merge(t);
        } catch (Exception e) {
        }
    }
    
    @Override
    public void delete(T t) {
        try {
            this.getEntityManager().getTransaction().begin();
            this.getEntityManager().remove(t);
            this.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            this.getEntityManager().getTransaction().rollback();
        }
    }

    @Override
    public T find(ID id) {
        return this.getEntityManager().find(clazz, id);
    }
    
    @Override
    public List<T> list() {
        return this.getEntityManager().createQuery("select p from Pessoa p").getResultList();
    }

}
