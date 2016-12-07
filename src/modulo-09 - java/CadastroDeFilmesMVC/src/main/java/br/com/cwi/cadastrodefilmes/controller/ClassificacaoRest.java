package br.com.cwi.cadastrodefilmes.controller;

import br.com.cwi.cadastrodefilmes.entity.Classificacao;
import br.com.cwi.cadastrodefilmes.service.ClassificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carlos H. Nonnemacher
 */
@RestController
@RequestMapping("/rest/classificacao")
public class ClassificacaoRest {

    @Autowired
    ClassificacaoService service;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Classificacao> list(Pageable pgbl) {
        return service.findAll(pgbl);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Classificacao save(@RequestBody Classificacao p) {
        return service.save(p);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Classificacao p) {
        service.delete(p.getId());
    }
}

