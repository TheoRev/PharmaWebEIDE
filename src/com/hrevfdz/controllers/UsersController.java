package com.hrevfdz.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.hrevfdz.dao.UsersDAO;
import com.hrevfdz.models.Users;
import com.hrevfdz.services.IPharmacy;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class UsersController implements Serializable {
    
    private List<Users> usuarios;
    private Users usuario;
    
    @PostConstruct
    public void init() {
        usuario = new Users();
//        showWellcomeMsge();
    }
    
    public String logear() {
        FacesMessage message = null;
        String ruta = null;
        final String query = "select u from Users u where u.username='" + usuario.getUsername()
                + "' and u.password='" + usuario.getPassword() + "'";
        IPharmacy<Users> dao = new UsersDAO();
        
        try {
            List<Users> lista = dao.findByQuery(query);
            if (lista.size() == 1) {
                for (Users u : lista) {
                    if (u.getUsername().equals(usuario.getUsername())
                            && u.getPassword().equals(usuario.getPassword())) {
                        ruta = "views/sale?faces-redirect=true";
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuario);
                        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ACCESO CONCEDIDO",
                                "Bienvenido" + usuario.getUsername().toUpperCase());
                    } else {
                        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR EN LA VALIDACION",
                                "Usuario o Password incorrectos");
                        ruta = "index";
                    }
                }
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR EN LA VALIDACION",
                        "Usuario o Password incorrectos");
                ruta = "index";
            }
        } catch (Exception ex) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR EN LA VALIDACION", ex.getMessage());
            ruta = "index";
        }
        
        FacesContext.getCurrentInstance().addMessage(null, message);
        return ruta;
    }
    
    private void showWellcomeMsge() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "ACCESO CONCEDIDO", "Bienvenido " + getUsuario().getUsername().toUpperCase());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    public List<Users> getUsuarios() {
        return usuarios;
    }
    
    public void setUsuarios(List<Users> usuarios) {
        this.usuarios = usuarios;
    }
    
    public Users getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }
    
}
