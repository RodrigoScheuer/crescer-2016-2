/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.redesocial.controller;

import br.com.cwi.redesocial.entity.Perfil;
import br.com.cwi.redesocial.servico.PerfilServico;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rodrigo
 */
@RestController
public class PerfilRest {

    @Autowired
    PerfilServico servico;

    private Date data() {
        return new Date();
    }

    @RequestMapping("/lista")
    public List<Perfil> listaPerfil() {
        return (List<Perfil>) servico.buscarTodos();
    }

    @RequestMapping(value = "/lista", method = POST)
    public void add(@RequestBody Perfil p) {
        p.setDataNascimento(data());
        servico.add(p);
        servico.buscarTodos();
    }
    
    @RequestMapping("/")
    public String toIndex(Model model, @RequestParam(required = false) String name) {
        model.addAttribute("name", name == null ? "Rodrigo Scheuer" : name);
        return "Index";
    }

}
