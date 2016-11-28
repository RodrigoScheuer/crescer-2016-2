/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.dao;

import br.com.cwi.crescer.aula3.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rodrigo.scheuer
 */
public class PessoaDao implements IDao<Pessoa, Long> {

    @Override
    public void insert(Pessoa pessoa) {

        final EntityManagerFactory entityManagerFactory;
        entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager entityManager;
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        try {

            entityManager.persist(pessoa);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void delete(Pessoa pessoa) {

        final EntityManagerFactory entityManagerFactory;
        entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager entityManager;
        entityManager = entityManagerFactory.createEntityManager();

        if (entityManager.isOpen()) {

            entityManager.getTransaction().begin();
            try {
                entityManager.remove(pessoa);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                entityManager.getTransaction().rollback();
            }
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public Pessoa find(Long id) {

        final EntityManagerFactory entityManagerFactory;
        entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager entityManager;
        entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(Pessoa.class, id);
    }

    @Override
    public List<Pessoa> findAll() {
        
        final EntityManagerFactory entityManagerFactory;
        entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager entityManager;
        entityManager = entityManagerFactory.createEntityManager();
        
        return entityManager.createQuery("select p from Pessoa p").getResultList();
    }
}
