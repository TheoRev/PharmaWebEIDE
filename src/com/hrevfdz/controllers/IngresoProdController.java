package com.hrevfdz.controllers;

import com.hrevfdz.dao.IngresoProductoDAO;
import com.hrevfdz.models.IngresoProducto;
import com.hrevfdz.models.StockProducto;
import com.hrevfdz.services.IPharmacy;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class IngresoProdController implements Serializable {

    private List<IngresoProducto> ingresoProductos;
    private IngresoProducto ingresoProducto;
    private List<StockProducto> stockProductos;
    private StockProducto stockProducto;

    @PostConstruct
    public void init() {
        ingresoProducto = new IngresoProducto();
        stockProducto = new StockProducto();
        doFindAll();
    }

    public void doFindAll() {
        FacesMessage message = null;
        IPharmacy<IngresoProducto> dao = new IngresoProductoDAO();

        try {
            ingresoProductos = dao.findAll();
        } catch (Exception ex) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR EN DB", ex.getMessage());
        }

        if (message != null) {
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public List<IngresoProducto> getIngresoProductos() {
        return ingresoProductos;
    }

    public void setIngresoProductos(List<IngresoProducto> ingresoProductos) {
        this.ingresoProductos = ingresoProductos;
    }

    public IngresoProducto getIngresoProducto() {
        return ingresoProducto;
    }

    public void setIngresoProducto(IngresoProducto ingresoProducto) {
        this.ingresoProducto = ingresoProducto;
    }

    public List<StockProducto> getStockProductos() {
        return stockProductos;
    }

    public void setStockProductos(List<StockProducto> stockProductos) {
        this.stockProductos = stockProductos;
    }

    public StockProducto getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(StockProducto stockProducto) {
        this.stockProducto = stockProducto;
    }

}
