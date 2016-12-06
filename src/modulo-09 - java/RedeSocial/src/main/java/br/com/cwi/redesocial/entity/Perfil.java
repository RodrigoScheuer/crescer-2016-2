/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.redesocial.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author Rodrigo
 */
@Entity
public class Perfil implements Serializable {
    
    private final String sequency = "SEQ_PERFIL";
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = sequency)
    @SequenceGenerator(name = sequency, sequenceName = sequency, allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_PERFIL")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "SOBRENOME")
    private String sobrenome;
    
    @Column(name = "DT_NASCIMENTO", nullable = true)
    @Temporal(DATE)
    @Basic(optional = true)
    private Date dataNascimento;
    
    @Basic(optional = false)
    @Column(name = "SENHA")
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
