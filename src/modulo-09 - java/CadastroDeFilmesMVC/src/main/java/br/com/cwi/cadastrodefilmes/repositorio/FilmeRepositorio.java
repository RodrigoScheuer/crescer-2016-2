/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.cadastrodefilmes.repositorio;

import br.com.cwi.cadastrodefilmes.entity.Filme;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author rodrigo.scheuer
 */
public interface FilmeRepositorio extends PagingAndSortingRepository<Filme, Long>{

    List<Filme> findByTitulo(String titulo);
    
}
