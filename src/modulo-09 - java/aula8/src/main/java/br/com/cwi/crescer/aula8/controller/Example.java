/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author rodrigo.scheuer
 */
@Controller
@RequestMapping(value = "/")
public class Example {

    @RequestMapping(method = GET)
    String toIndex(Model model, @RequestParam(required = false) String name) {
        model.addAttribute("name", name == null ? "Carlos H. Nonnemacher" : name);
        return "index";
    }

}
