
package br.com.cwi.cadastrodefilmes.service;

import br.com.cwi.cadastrodefilmes.entity.Filme;
import br.com.cwi.cadastrodefilmes.repositorio.FilmeRepositorio;
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
public class FilmeService {

    @Autowired
    FilmeRepositorio repository;

    public List<Filme> list() {
        Filme filme = new Filme();
        filme.setTitulo("Capitão America");
        return Stream.of(filme).collect(Collectors.toList());
    }

    public Page<Filme> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Filme> findAll() {
        return repository.findAll();
    }

    public Filme save(Filme p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Filme findOne(Long id) {
        return repository.findOne(id);
    }

}
