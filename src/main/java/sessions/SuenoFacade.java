/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import sessions.Local.AbstractFacade;
import sessions.Local.SuenoFacadeLocal;
import entities.Sueno;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kenlu
 */
@Stateless
public class SuenoFacade extends AbstractFacade<Sueno> implements SuenoFacadeLocal {

    @PersistenceContext(unitName = "nek_G1_GestorTareas_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SuenoFacade() {
        super(Sueno.class);
    }
    @Override
    public Integer getMaxId(){
        return (em.createQuery("SELECT MAX(s.id) FROM Sueno s", BigDecimal.class).getSingleResult()).intValue();
    }
}
