/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula3;

import br.com.cwi.crescer.aula3.dao.PessoaDao;
import br.com.cwi.crescer.aula3.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rodrigo.scheuer
 */
public class Run {

    public static void main(String[] args) {

        final EntityManagerFactory entityManagerFactory;
        entityManagerFactory = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager entityManager;
        entityManager = entityManagerFactory.createEntityManager();

        PessoaDao pessoaDao = new PessoaDao();
        Pessoa pessoa = new Pessoa();
        pessoa.setNmPessoa("Rodrigo Scheuer");
        //pessoaDao.insert(pessoa);
        
        List<Pessoa> pessoasDoBanco = pessoaDao.findAll();
        
        for (Pessoa p : pessoasDoBanco) {
            System.out.println(p.getNmPessoa());
        }
        
        //pessoaDao.delete();
        
        entityManager.close();
        entityManagerFactory.close();        
    }
}
