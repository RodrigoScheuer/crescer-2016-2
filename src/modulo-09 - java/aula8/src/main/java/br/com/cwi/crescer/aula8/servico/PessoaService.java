/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.servico;

import br.com.cwi.crescer.aula8.repositorio.PessoaRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodrigo.scheuer
 */
@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepositorio;

    public Iterable<Pessoa> buscarTodos() {
        return pessoaRepositorio.findAll();
    }

    public void add(Pessoa pessoa) {
        pessoa.setDtNascimento(new Date());
        pessoaRepositorio.save(pessoa);
    }

}
