package br.com.cwi.cadastrodefilmes.controller;

import br.com.cwi.cadastrodefilmes.entity.Ator;
import br.com.cwi.cadastrodefilmes.service.AtorService;
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
@RequestMapping("/rest/ator")
public class AtorRest {

    @Autowired
    AtorService service;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Ator> list(Pageable pgbl) {
        return service.findAll(pgbl);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Ator save(@RequestBody Ator p) {
        return service.save(p);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Ator p) {
        service.delete(p.getId());
    }
}
