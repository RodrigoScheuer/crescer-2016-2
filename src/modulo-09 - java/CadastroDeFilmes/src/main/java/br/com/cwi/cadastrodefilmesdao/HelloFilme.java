package br.com.cwi.cadastrodefilmesdao;


import br.com.cwi.cadastrodefilmes.entity.Classificacao;
import br.com.cwi.cadastrodefilmes.entity.Filme;
import br.com.cwi.cadastrodefilmes.entity.Genero;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class HelloFilme {

    @EJB
    private FilmeBean filmeBean;

    private Filme filme;
    private Genero genero;
    private Classificacao classificacao;
    private List<Filme> filmes;
    private List<Genero> generos;
    private List<Classificacao> classificacoes;

    @PostConstruct
    public void init() {
        this.filme = new Filme();
        this.genero = new Genero();
        this.classificacao = new Classificacao();
        this.filmes = filmeBean.findAll();
        this.filmes.sort((a, b) -> a.getId().compareTo(b.getId()));
        this.generos = filmeBean.findAllGeneros();
        this.classificacoes = filmeBean.findAllClassificacoes();
    }
    
    public void adicionar() {
        
        filmeBean.insert2(filme, genero, classificacao);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }

    public FilmeBean getFilmeBean() {
        return filmeBean;
    }

    public void setFilmeBean(FilmeBean filmeBean) {
        this.filmeBean = filmeBean;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<Classificacao> getClassificacoes() {
        return classificacoes;
    }

    public void setClassificacoes(List<Classificacao> classificacoes) {
        this.classificacoes = classificacoes;
    }
}