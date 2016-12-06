/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.redesocial.repositorio;

import br.com.cwi.redesocial.entity.Perfil;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Rodrigo
 */
public interface PerfilRepositorio extends CrudRepository<Perfil, Long>{
}
