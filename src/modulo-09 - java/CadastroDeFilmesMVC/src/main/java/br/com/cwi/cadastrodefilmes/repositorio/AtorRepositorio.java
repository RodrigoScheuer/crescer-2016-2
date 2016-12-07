package br.com.cwi.cadastrodefilmes.repositorio;

import br.com.cwi.cadastrodefilmes.entity.Ator;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Rodrigo
 */
public interface AtorRepositorio extends PagingAndSortingRepository<Ator, Long>{

    List<Ator> findByNome(String nome);
    
}
