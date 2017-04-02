/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrevfdz.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author theo
 */
@Entity
@Table(name = "laboratorio", catalog = "farmasur", schema = "pharmacy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Laboratorio.findAll", query = "SELECT l FROM Laboratorio l")
    , @NamedQuery(name = "Laboratorio.findByCodLab", query = "SELECT l FROM Laboratorio l WHERE l.codLab = :codLab")
    , @NamedQuery(name = "Laboratorio.findByNomLab", query = "SELECT l FROM Laboratorio l WHERE l.nomLab = :nomLab")})
public class Laboratorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_lab")
    private Integer codLab;
    @Column(name = "nom_lab")
    private String nomLab;
    @OneToMany(mappedBy = "codLab")
    private List<StockProducto> stockProductoList;

    public Laboratorio() {
    }

    public Laboratorio(Integer codLab) {
        this.codLab = codLab;
    }

    public Integer getCodLab() {
        return codLab;
    }

    public void setCodLab(Integer codLab) {
        this.codLab = codLab;
    }

    public String getNomLab() {
        return nomLab;
    }

    public void setNomLab(String nomLab) {
        this.nomLab = nomLab;
    }

    @XmlTransient
    public List<StockProducto> getStockProductoList() {
        return stockProductoList;
    }

    public void setStockProductoList(List<StockProducto> stockProductoList) {
        this.stockProductoList = stockProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLab != null ? codLab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laboratorio)) {
            return false;
        }
        Laboratorio other = (Laboratorio) object;
        if ((this.codLab == null && other.codLab != null) || (this.codLab != null && !this.codLab.equals(other.codLab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hrevfdz.models.Laboratorio[ codLab=" + codLab + " ]";
    }
    
}
