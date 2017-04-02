package com.hrevfdz.controllers;

import com.hrevfdz.dao.LaboratorioDAO;
import com.hrevfdz.models.Laboratorio;
import com.hrevfdz.services.IPharmacy;
import com.hrevfdz.util.AccionUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LaboratorioController implements Serializable{

    private List<Laboratorio> laboratorios;
    private Laboratorio laboratorio;
    private String accion;

    @PostConstruct
    public void init() {
        laboratorio = new Laboratorio();
        doListarLabs();
    }

    public void doListarLabs() {
        FacesMessage message = null;
        IPharmacy<Laboratorio> dao = new LaboratorioDAO();

        try {
            laboratorios = dao.findAll();
        } catch (Exception ex) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR EN DB", ex.getMessage());
        }

        if (message != null) {
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void doCreate() {
        FacesMessage msg = null;
        IPharmacy dao = new LaboratorioDAO();

        try {
            boolean result = dao.Create(laboratorio);

            if (result) {
                laboratorios.add(laboratorios.size(), laboratorio);
                laboratorio = new Laboratorio();
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "Datos guardado correctamente");
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "El proceso no se ejecutó");
            }
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "FATAL ERROR", e.getMessage());
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void doUpdate(Laboratorio lab) {
        FacesMessage msg = null;
        IPharmacy dao = new LaboratorioDAO();

        try {
            boolean result = dao.Update(lab);

            if (result) {
                laboratorios.clear();
                doListarLabs();
//                selectedTratamiento = null;
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "Se modificó correctamente");
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "El proceso no se ejecutó");
            }
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "FATAL ERROR", e.getMessage());
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void doDelete(Laboratorio lab) {
        FacesMessage msg = null;
        IPharmacy dao = new LaboratorioDAO();

        try {
            boolean result = dao.Delete(lab);

            if (result) {
                laboratorios.clear();
                doListarLabs();
//                selectedTratamiento = null;
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "Se eliminó correctamente");
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "El proceso no se ejecutó");
            }
        } catch (Exception e) {
            msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "FATAL ERROR", e.getMessage());
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void doNew() {
        accion = AccionUtil.CREATE;
        laboratorio = new Laboratorio();
    }

    public void doUpgrade(Laboratorio l) {
        accion = AccionUtil.UPDATE;
        laboratorio = l;
    }

    public void doExecute() {
        switch (accion) {
            case AccionUtil.CREATE:
                doCreate();
                break;
            case AccionUtil.UPDATE:
                doUpdate(laboratorio);
                break;
        }
    }

    public List<Laboratorio> getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(List<Laboratorio> laboratorios) {
        this.laboratorios = laboratorios;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

}
