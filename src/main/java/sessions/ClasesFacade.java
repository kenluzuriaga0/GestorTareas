/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import sessions.Local.AbstractFacade;
import sessions.Local.ClasesFacadeLocal;
import entities.Clases;
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
        try{
        return (em.createQuery("SELECT MAX(e.id) FROM Clases e", Integer.class).getSingleResult()).intValue();
        } catch (NullPointerException nullo) {
            return 0;
        }
    }
}
