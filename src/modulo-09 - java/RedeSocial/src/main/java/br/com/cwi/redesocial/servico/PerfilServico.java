/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.redesocial.servico;

import br.com.cwi.redesocial.entity.Perfil;
import br.com.cwi.redesocial.repositorio.PerfilRepositorio;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodrigo
 */
@Service
public class PerfilServico {

    @Autowired
    PerfilRepositorio Repositorio;

    public Iterable<Perfil> buscarTodos() {
        return Repositorio.findAll();
    }

    public void add(Perfil perfil) {
        perfil.setDataNascimento(new Date());
        Repositorio.save(perfil);
    }
}
