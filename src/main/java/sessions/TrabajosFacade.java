/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import sessions.Local.TrabajosFacadeLocal;
import sessions.Local.AbstractFacade;
import entities.Trabajos;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kenlu
 */
@Stateless
public class TrabajosFacade extends AbstractFacade<Trabajos> implements TrabajosFacadeLocal {

    @PersistenceContext(unitName = "nek_G1_GestorTareas_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrabajosFacade() {
        super(Trabajos.class);
    }
    
    @Override
    public Integer getMaxId(){
        return (em.createQuery("SELECT MAX(t.id) FROM Trabajos t", BigDecimal.class).getSingleResult()).intValue();
    }
    
    
    
}
