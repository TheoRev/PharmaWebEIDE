/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrevfdz.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author theo
 */
@Entity
@Table(name = "sale", catalog = "farmasur", schema = "pharmacy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sale.findAll", query = "SELECT s FROM Sale s")
    , @NamedQuery(name = "Sale.findByCodSale", query = "SELECT s FROM Sale s WHERE s.codSale = :codSale")
    , @NamedQuery(name = "Sale.findByCantidad", query = "SELECT s FROM Sale s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "Sale.findByPrecio", query = "SELECT s FROM Sale s WHERE s.precio = :precio")
    , @NamedQuery(name = "Sale.findBySubtotal", query = "SELECT s FROM Sale s WHERE s.subtotal = :subtotal")
    , @NamedQuery(name = "Sale.findByFecha", query = "SELECT s FROM Sale s WHERE s.fecha = :fecha")})
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_sale")
    private Integer codSale;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;
    @Column(name = "subtotal")
    private double subtotal;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "cod_stock", referencedColumnName = "cod_stock")
    @ManyToOne(optional = false)
    private StockProducto codStock;

    public Sale() {
    }

    public Sale(Integer codSale) {
        this.codSale = codSale;
    }

    public Sale(Integer codSale, Integer cantidad, double precio, Date fecha) {
        this.codSale = codSale;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
    }

    public Integer getCodSale() {
        return codSale;
    }

    public void setCodSale(Integer codSale) {
        this.codSale = codSale;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public StockProducto getCodStock() {
        return codStock;
    }

    public void setCodStock(StockProducto codStock) {
        this.codStock = codStock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSale != null ? codSale.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        if ((this.codSale == null && other.codSale != null) || (this.codSale != null && !this.codSale.equals(other.codSale))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hrevfdz.models.Sale[ codSale=" + codSale + " ]";
    }
    
}
