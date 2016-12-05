/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.servico.Pessoa;
import br.com.cwi.crescer.aula8.servico.PessoaService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rodrigo.scheuer
 */
@RestController
public class PessoaRest {

    @Autowired
    PessoaService service;

    //@RequestMapping(value = "/current_date_time")
    public Date date() {
        return new Date();
    }

    @RequestMapping("/listaPessoa")
    public List<Pessoa> listaPessoas() {
        return (List<Pessoa>) service.buscarTodos();
    }

    @RequestMapping(value= "/listaPessoa", method = POST)
    public void add(@RequestBody Pessoa p) {
        p.setDtNascimento(date());
        service.add(p);
        service.buscarTodos();
    }
}
