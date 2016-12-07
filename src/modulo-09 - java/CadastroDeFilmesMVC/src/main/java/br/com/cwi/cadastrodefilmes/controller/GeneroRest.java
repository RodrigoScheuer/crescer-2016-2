package br.com.cwi.cadastrodefilmes.controller;

import br.com.cwi.cadastrodefilmes.entity.Genero;
import br.com.cwi.cadastrodefilmes.service.GeneroService;
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
@RequestMapping("/rest/genero")
public class GeneroRest {

    @Autowired
    GeneroService service;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Genero> list(Pageable pgbl) {
        return service.findAll(pgbl);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Genero save(@RequestBody Genero p) {
        return service.save(p);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Genero p) {
        service.delete(p.getId());
    }
}
