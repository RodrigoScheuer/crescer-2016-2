
package br.com.cwi.cadastrodefilmes.service;

import br.com.cwi.cadastrodefilmes.entity.Genero;
import br.com.cwi.cadastrodefilmes.repositorio.GeneroRepositorio;
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
public class GeneroService {

    @Autowired
    GeneroRepositorio repository;

    public List<Genero> list() {
        Genero genero = new Genero();
        genero.setDescricao("Ação");
        return Stream.of(genero).collect(Collectors.toList());
    }

    public Page<Genero> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Genero> findAll() {
        return repository.findAll();
    }

    public Genero save(Genero p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Genero findOne(Long id) {
        return repository.findOne(id);
    }

}
