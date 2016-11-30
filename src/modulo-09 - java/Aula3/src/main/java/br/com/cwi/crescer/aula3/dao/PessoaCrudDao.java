/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3.dao;

import br.com.cwi.crescer.aula3.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Rodrigo
 */
public class PessoaCrudDao extends AbstractCrud<Pessoa, Long> {

    final EntityManager entityManager;

    public PessoaCrudDao(Class<Pessoa> clazz, EntityManager entityManager) {
        super(clazz);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
        public List<Pessoa> list() {
        return this.getEntityManager().createQuery("select p from Pessoa p").getResultList();
    }

}
