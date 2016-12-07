package br.com.cwi.cadastrodefilmes.service;

import br.com.cwi.cadastrodefilmes.entity.Ator;
import br.com.cwi.cadastrodefilmes.repositorio.AtorRepositorio;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Rodrigo
 */
@Service
public class AtorService {

    @Autowired
    AtorRepositorio repository;

    public List<Ator> list() {
        Ator ator = new Ator();
        ator.setNome("Rodrigo Scheuer");
        return Stream.of(ator).collect(Collectors.toList());
    }

    public Page<Ator> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Ator> findAll() {
        return repository.findAll();
    }

    public Ator save(Ator p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Ator findOne(Long id) {
        return repository.findOne(id);
    }

}
