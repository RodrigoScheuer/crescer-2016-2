package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.UsuarioCadastradoBean;
import br.com.cwi.crescer.aula5.dao.UsuarioCadastradoDao;
import br.com.cwi.crescer.aula5.entity.UsuarioCadastrado;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Rodrigo
 */
@ManagedBean
@ViewScoped
public class UsuarioCadastradoMBean extends AbstractMBean<UsuarioCadastrado, Long, UsuarioCadastradoDao, UsuarioCadastradoBean> {

    @EJB
    private UsuarioCadastradoBean cadastroBean;

    @PostConstruct
    public void init() {
        this.limpar();
    }

    @Override
    public UsuarioCadastradoBean getBean() {
        return cadastroBean;
    }
    
    @Override
    public void limpar() {
        this.setEntity(new UsuarioCadastrado());
        this.setList(this.getBean().findAll());
    }

}
