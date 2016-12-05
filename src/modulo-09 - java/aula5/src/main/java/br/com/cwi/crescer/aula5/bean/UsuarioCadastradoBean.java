package br.com.cwi.crescer.aula5.bean;

import br.com.cwi.crescer.aula5.dao.UsuarioCadastradoDao;
import br.com.cwi.crescer.aula5.entity.UsuarioCadastrado;
import javax.ejb.Stateless;

/**
 * @author Carlos H. Nonnemacher
 */
@Stateless
public class UsuarioCadastradoBean extends AbstractBean<UsuarioCadastrado, Long, UsuarioCadastradoDao> {

    private UsuarioCadastradoDao dao;

    @Override
    public UsuarioCadastradoDao getDao() {
        if (dao == null) {
            dao = new UsuarioCadastradoDao(this.getEntityManager());
        }
        return dao;
    }

}
