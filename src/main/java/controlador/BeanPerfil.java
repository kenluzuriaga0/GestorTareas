/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entities.Usuarios;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sessions.Local.UsuariosFacadeLocal;

/**
 *
 * @author kenlu
 */
@Named(value = "beanPerfil")
@ViewScoped
public class BeanPerfil implements Serializable{

    @EJB
    private UsuariosFacadeLocal usuariosFacade;
private Usuarios usuario;
    
    public BeanPerfil() {
        usuario = (Usuarios)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggeado");
    }
    public String fechaFormateada(){
        SimpleDateFormat formatito = new SimpleDateFormat("dd/MM/yyyy");
        return formatito.format(usuario.getFechaNac());
    
    
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
