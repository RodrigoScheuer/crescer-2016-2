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

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();

        PessoaDao pessoaDao = new PessoaDao(em);
        Pessoa pessoa = new Pessoa();
        //pessoa.setIdPessoa(1l);
        pessoa.setNmPessoa("Rodrigo Scheuer");
        
        pessoaDao.insert(pessoa);
        
        pessoaDao.findByPessoa(pessoa).forEach(p -> System.out.println(p.getNmPessoa()));
        em.close();
        emf.close();        
    }
}
