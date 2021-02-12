/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entities.Usuarios;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author kenlu
 */
@Named(value = "beanTemplate")
@ViewScoped
public class beanTemplate implements Serializable{

   
    public beanTemplate() {
    }
   
    public void validarSession(){
        
        try {
            
        Usuarios user = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggeado");
            
        if(user==null ){
            FacesContext.getCurrentInstance().getExternalContext().redirect("../denegado.xhtml");
        }
        
        } catch (Exception e) {
        
        
        }
        
        
    }
    
    
}
