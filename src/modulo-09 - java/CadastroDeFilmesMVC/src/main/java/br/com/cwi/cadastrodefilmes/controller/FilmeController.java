package br.com.cwi.cadastrodefilmes.controller;

import br.com.cwi.cadastrodefilmes.entity.Filme;
import br.com.cwi.cadastrodefilmes.service.ClassificacaoService;
import br.com.cwi.cadastrodefilmes.service.FilmeService;
import br.com.cwi.cadastrodefilmes.service.GeneroService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Rodrigo
 */
@Controller
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    FilmeService service;
    
    @Autowired
    GeneroService generoService;
    
    @Autowired
    ClassificacaoService classificacaoService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());

        Filme filme = new Filme();
        if (id != null) {
            filme = service.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        model.addAttribute("filme", filme);
        model.addAttribute("genero", generoService.findAll());
        model.addAttribute("classificacao", classificacaoService.findAll());
        model.addAttribute("filmes", service.findAll(pageable));
        return "filme";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Filme filme, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            service.save(filme);
            return "redirect:filme";
        }
        return "filme";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Filme> filmes = service.findAll(pageable);
        model.addAttribute("filmes", filmes);
        return "filme";
    }

}
