package br.com.cwi.crescer.aula5.dao;

import br.com.cwi.crescer.aula5.entity.UsuarioCadastrado;
import javax.persistence.EntityManager;

/**
 * @author Rodrigo
 */
public class UsuarioCadastradoDao extends AbstractDao<UsuarioCadastrado, Long> {

    final EntityManager entityManager;

    public UsuarioCadastradoDao(EntityManager entityManager) {
        super(UsuarioCadastrado.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
