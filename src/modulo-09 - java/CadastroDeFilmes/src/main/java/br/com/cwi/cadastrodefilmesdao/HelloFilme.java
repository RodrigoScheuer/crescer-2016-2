package br.com.cwi.cadastrodefilmesdao;


import br.com.cwi.cadastrodefilmes.entity.Filme;
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
    private List<Filme> filmes;

    @PostConstruct
    public void init() {
        this.filme = new Filme();
        this.filmes = filmeBean.findAll();
        this.filmes.sort((a, b) -> a.getId().compareTo(b.getId()));
    }
    
    public void adicionar() {
        filmeBean.insert(filme);
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
}