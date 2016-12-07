package br.com.cwi.cadastrodefilmes.repositorio;

import br.com.cwi.cadastrodefilmes.entity.Genero;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Rodrigo
 */
public interface GeneroRepositorio extends PagingAndSortingRepository<Genero, Long>{

    List<Genero> findByDescricao(String descricao);
    
}
