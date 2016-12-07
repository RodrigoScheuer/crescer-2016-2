/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.cadastrodefilmes.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name = "Filme")
public class Filme implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FILME")
    @SequenceGenerator(name = "SEQ_FILME", sequenceName = "SEQ_FILME", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_GENERO")
    @Basic(optional = false)
    private Genero genero;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_CLASSIFICACAO")
    private Classificacao classificacao;

    @Basic(optional = false)
    private String diretor;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DT_LANCAMENTO", nullable = true)
    @Temporal(DATE)
    private Date dataDeLancamento;

    /*@ManyToOne
    @JoinColumn(name = "ID")
    private Elenco elenco;
    
    @ManyToOne
    @JoinColumn(name = "ID")
    private Idioma idioma;*/
    //-----------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Date getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(Date dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }
    
    

    /*public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
    
    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }*/

    public String toStringGenero() {
        return this.genero.toString();
    }
    
    public String toStringClassificacao(){
        return this.classificacao.toString();
    }
}
