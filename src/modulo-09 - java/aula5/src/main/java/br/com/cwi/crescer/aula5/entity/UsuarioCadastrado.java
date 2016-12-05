package br.com.cwi.crescer.aula5.entity;

import br.com.cwi.crescer.aula5.utils.UserDetails;
import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Rodrigo
 */
@Entity
@Table(name = "UsuarioCadastrado")
public class UsuarioCadastrado implements UserDetails, Serializable {

    private static final String SQ_NAME = "SQ_UsuarioCadastrado";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Basic(optional = false)
    @Column(name = "EMAIL_USUARIO")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "SENHA_USUARIO")
    private String senha;
    
    @Basic(optional = false)
    @Column(name = "CONFIRMASENHA_USUARIO")
    private String confirmaSenha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
