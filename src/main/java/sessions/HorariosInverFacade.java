/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import sessions.Local.AbstractFacade;
import sessions.Local.HorariosInverFacadeLocal;
import entities.HorariosInver;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kenlu
 */
@Stateless
public class HorariosInverFacade extends AbstractFacade<HorariosInver> implements HorariosInverFacadeLocal {

    @PersistenceContext(unitName = "nek_G1_GestorTareas_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorariosInverFacade() {
        super(HorariosInver.class);
    }
        @Override
    public int getMaxId() {
        return (em.createQuery("SELECT MAX(h.id) FROM Horarios_inver h", BigDecimal.class).getSingleResult()).intValue();
    }
    
}
