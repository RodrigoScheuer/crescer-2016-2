package br.com.cwi.cadastrodefilmesdao;


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
public class HelloGenero {

    @EJB
    private GeneroBean generoBean;

    private Genero genero;
    private List<Genero> generos;

    @PostConstruct
    public void init() {
        this.genero = new Genero();
        this.generos = generoBean.findAll();
        this.generos.sort((a, b) -> a.getId().compareTo(b.getId()));
    }

    public GeneroBean getGeneroBean() {
        return generoBean;
    }

    public void setGeneroBean(GeneroBean generoBean) {
        this.generoBean = generoBean;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }
    
    
    public void adicionar() {
        generoBean.insert(genero);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }
}