/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.cadastrodefilmesdao;

import br.com.cwi.cadastrodefilmes.entity.Classificacao;
import br.com.cwi.cadastrodefilmes.entity.Filme;
import br.com.cwi.cadastrodefilmes.entity.Genero;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rodrigo
 */
@Stateless
public class FilmeBean extends AbstractFilmeDao<Filme, Genero, Classificacao, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public FilmeBean() {
        super(Filme.class, Genero.class, Classificacao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Filme> findAll() {
        return this.getEntityManager().createQuery("select f from Filme f").getResultList();
    }

    public List<Genero> findAllGeneros() {
        return this.getEntityManager().createQuery("select g from Genero g").getResultList();
    }

    public List<Classificacao> findAllClassificacoes() {
        return this.getEntityManager().createQuery("select c from Classificacao c").getResultList();
    }

}
