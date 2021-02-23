/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entities.Usuarios;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sessions.Local.UsuariosFacadeLocal;

/**
 *
 * @author kenlu
 */
@Named(value = "beanRegistroUser")
@ViewScoped
public class BeanRegistroUser implements Serializable{

    @EJB
    private UsuariosFacadeLocal usuariosFacade;
    private Usuarios usuario;

    public BeanRegistroUser() {
        usuario = new Usuarios();
        
    }
    
    public void registrarUsuario(){
        usuario.setId(BigDecimal.valueOf(1+usuariosFacade.getMaxId()));
        usuariosFacade.create(usuario);
        
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    
    
}
