/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entities.Usuarios;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import sessions.UsuariosFacade;
import sessions.Local.UsuariosFacadeLocal;

/**
 *
 * @author kenlu
 */
@Named(value = "beanIndex")
@SessionScoped
public class BeanIndex implements Serializable {

    @EJB
    private UsuariosFacadeLocal usuariosFacade;
    private Usuarios usuarios;
    
    public BeanIndex() {
        usuarios = new Usuarios();
        usuariosFacade = new UsuariosFacade();

    }
    public UsuariosFacadeLocal getUsuariosFacade() {
        return usuariosFacade;
    }

    public void setUsuariosFacade(UsuariosFacadeLocal usuariosFacade) {
        this.usuariosFacade = usuariosFacade;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public String logearse() {

        Usuarios user;
        String pagina = null;
        try {
            user = usuariosFacade.iniciarSesion(usuarios);

            if (user != null) {

                //la sesion activa
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loggeado", user);

                pagina = "horarios?faces-redirect=true"; //convertir navegacion explicita
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES, "Ingresado con exito"));
            } else {
                FacesContext.getCurrentInstance().addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", "Datos ingresados son incorrectos"));
            }

        } catch (Exception e) {
            System.out.println("OjoH " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Session "+e.getMessage()));
        }
        return pagina;

    }

    public void logOut() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getApplicationMap().remove(getRequest().getRequestedSessionId());
            // context.getExternalContext().getApplicationMap().remove("usuario");
            context.getExternalContext().invalidateSession();
            context.getExternalContext().redirect("index.xhtml");
        } catch (Exception ex) {
            System.out.println("logOut() Error " + ex.getMessage());
        }
    }
    public HttpServletRequest getRequest() throws Exception {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }


}
