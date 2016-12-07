package br.com.cwi.cadastrodefilmes.controller;

import br.com.cwi.cadastrodefilmes.entity.Filme;
import br.com.cwi.cadastrodefilmes.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rodrigo
 */
@RestController
@RequestMapping("/rest/filme")
public class FilmeRest {

    @Autowired
    FilmeService service;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Filme> list(Pageable pgbl) {
        return service.findAll(pgbl);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Filme save(@RequestBody Filme p) {
        return service.save(p);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Filme p) {
        service.delete(p.getId());
    }
}
