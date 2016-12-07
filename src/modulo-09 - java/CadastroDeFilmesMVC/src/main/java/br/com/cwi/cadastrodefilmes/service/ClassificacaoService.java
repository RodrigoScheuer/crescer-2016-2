
package br.com.cwi.cadastrodefilmes.service;

import br.com.cwi.cadastrodefilmes.entity.Classificacao;
import br.com.cwi.cadastrodefilmes.repositorio.ClassificacaoRepositorio;
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
public class ClassificacaoService {

    @Autowired
    ClassificacaoRepositorio repository;

    public List<Classificacao> list() {
        Classificacao classificacao = new Classificacao();
        classificacao.setDescricao("maiores de 16 anos");
        classificacao.setIdade(16);
        return Stream.of(classificacao).collect(Collectors.toList());
    }

    public Page<Classificacao> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Classificacao> findAll() {
        return repository.findAll();
    }

    public Classificacao save(Classificacao p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Classificacao findOne(Long id) {
        return repository.findOne(id);
    }

}
