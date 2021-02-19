/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Clases;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kenlu
 */
@Stateless
public class ClasesFacade extends AbstractFacade<Clases> implements ClasesFacadeLocal {

    @PersistenceContext(unitName = "nek_G1_GestorTareas_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClasesFacade() {
        super(Clases.class);
    }
        @Override
    public int getMaxId() {
        return (em.createQuery("SELECT MAX(e.id) FROM Clases e", BigDecimal.class).getSingleResult()).intValue();
    }
}
