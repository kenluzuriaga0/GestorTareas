/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import sessions.Local.AbstractFacade;
import sessions.Local.ClasesFacadeLocal;
import entities.Clases;
import entities.HorariosOcup;
import java.util.ArrayList;
import java.util.List;
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
        try {
            return (em.createQuery("SELECT MAX(e.id) FROM Clases e", Integer.class).getSingleResult()).intValue();
        } catch (NullPointerException nullo) {
            return 0;
        }
    }
    @Override
    public List<String> getHorasLunes(HorariosOcup horaOcup) throws Exception{
        return  em.createQuery("SELECT c.lunes FROM Clases c WHERE c.horarioOcup.id = :hora AND c.lunes <> :dia")
                .setParameter("hora", horaOcup.getId()).setParameter("dia", "-").getResultList();
    }

    @Override
    public List<String> getHorasMartes(HorariosOcup horaOcup) throws Exception {
     return  em.createQuery("SELECT c.martes FROM Clases c WHERE c.horarioOcup.id = :hora AND c.martes <> :dia")
                .setParameter("hora", horaOcup.getId()).setParameter("dia", "-").getResultList();
    }

    @Override
    public List<String> getHorasMiercoles(HorariosOcup horaOcup) throws Exception {
     return  em.createQuery("SELECT c.miercoles FROM Clases c WHERE c.horarioOcup.id = :hora AND c.miercoles <> :dia")
                .setParameter("hora", horaOcup.getId()).setParameter("dia", "-").getResultList();
    }

    @Override
    public List<String> getHorasJueves(HorariosOcup horaOcup) throws Exception {
    return  em.createQuery("SELECT c.jueves FROM Clases c WHERE c.horarioOcup.id = :hora AND c.jueves <> :dia")
                .setParameter("hora", horaOcup.getId()).setParameter("dia", "-").getResultList();
    }

    @Override
    public List<String> getHorasViernes(HorariosOcup horaOcup) throws Exception {
    return  em.createQuery("SELECT c.viernes FROM Clases c WHERE c.horarioOcup.id = :hora AND c.viernes <> :dia")
                .setParameter("hora", horaOcup.getId()).setParameter("dia", "-").getResultList();
    }

    @Override
    public List<String> getHorasSabado(HorariosOcup horaOcup) throws Exception {
    return  em.createQuery("SELECT c.sabado FROM Clases c WHERE c.horarioOcup.id = :hora AND c.sabado <> :dia")
                .setParameter("hora", horaOcup.getId()).setParameter("dia", "-").getResultList();
   }
    
}
