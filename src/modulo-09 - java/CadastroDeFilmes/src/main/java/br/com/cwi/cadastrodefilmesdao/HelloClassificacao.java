package br.com.cwi.cadastrodefilmesdao;


import br.com.cwi.cadastrodefilmes.entity.Classificacao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class HelloClassificacao {

    @EJB
    private ClassificacaoBean classificacaoBean;

    private Classificacao classificacao;
    private List<Classificacao> classificacaoes;

    @PostConstruct
    public void init() {
        this.classificacao = new Classificacao();
        this.classificacaoes = classificacaoBean.findAll();
        this.classificacaoes.sort((a, b) -> a.getId().compareTo(b.getId()));
    }

    public ClassificacaoBean getClassificacaoBean() {
        return classificacaoBean;
    }

    public void setClassificacaoBean(ClassificacaoBean classificacaoBean) {
        this.classificacaoBean = classificacaoBean;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public List<Classificacao> getClassificacaoes() {
        return classificacaoes;
    }

    public void setClassificacaoes(List<Classificacao> classificacaoes) {
        this.classificacaoes = classificacaoes;
    }
    
    public void adicionar() {
        classificacaoBean.insert(classificacao);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }
}