/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.cadastrodefilmes.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo
 */

@Entity
@Table(name = "Genero")
public class Genero implements Serializable {
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_GENERO")
    @SequenceGenerator(name = "SEQ_GENERO", sequenceName = "SEQ_GENERO", allocationSize = 1) 
    
    @Basic(optional = false)
    @Column(name = "ID_GENERO")
    private Long idGenero;
    
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;

    public Long getId() {
        return idGenero;
    }

    public void setId(Long id) {
        this.idGenero = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "" + this.descricao ;
    }
    
    
}
