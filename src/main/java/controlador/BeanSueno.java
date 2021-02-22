/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entities.Sueno;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sessions.SuenoFacade;
import sessions.Local.SuenoFacadeLocal;

/**
 *
 * @author kenlu
 */
@Named(value = "beanSueno")
@ViewScoped
public class BeanSueno implements Serializable{

    @EJB
    private SuenoFacadeLocal suenoFacade;
    private Sueno sueno;
    
    public void guardar(){
        suenoFacade.create(sueno);
    }
    

    public SuenoFacadeLocal getSuenoFacade() {
        return suenoFacade;
    }

    public void setSuenoFacade(SuenoFacadeLocal suenoFacade) {
        this.suenoFacade = suenoFacade;
    }

    public Sueno getSueno() {
        return sueno;
    }

    public void setSueno(Sueno sueno) {
        this.sueno = sueno;
    }

    
    
    public BeanSueno() {
        sueno = new Sueno();
        suenoFacade = new SuenoFacade();
    
    }
    
}
