/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import sessions.Local.HorarioLibreFacadeLocal;
import entities.HorarioLibre;
import entities.HorariosOcup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sessions.Local.AbstractFacade;

/**
 *
 * @author kenlu
 */
@Stateless
public class HorarioLibreFacade extends AbstractFacade<HorarioLibre> implements HorarioLibreFacadeLocal {

    @PersistenceContext(unitName = "nek_G1_GestorTareas_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorarioLibreFacade() {
        super(HorarioLibre.class);
    }

    @Override
    public int getMaxId() {
        try {
            return (em.createQuery("SELECT MAX(h.id) FROM HorarioLibre h", Integer.class).getSingleResult()).intValue();
        } catch (NullPointerException nullo) {
            return 0;
        }
    }

    @Override
    public HorarioLibre getTodoActivo(HorariosOcup horaOcup) {
        try {
            return em.createQuery("SELECT o FROM HorarioLibre o WHERE o.horarioOcup = :hora ", HorarioLibre.class)
                    .setParameter("hora", horaOcup).setMaxResults(1).getSingleResult();

        } catch (Exception nullo) {
            System.out.println(nullo.getMessage() + " ERROR");
            return null;
        }
    }
}
