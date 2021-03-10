/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import sessions.Local.AbstractFacade;
import sessions.Local.HorariosInverFacadeLocal;
import entities.HorariosInver;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    public Integer getMaxId() {
        try {
            return (em.createQuery("SELECT MAX(h.id) FROM HorariosInver h", Integer.class).getSingleResult()).intValue();
        } catch (NullPointerException nullo) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error MAX(ID HORARIOS_INVER)", nullo.getMessage()));
            
            return 0;
        }
    }
     @Override
    public void disableStatusbyUser(HorariosInver horariosInver) {

        String sql = "UPDATE Horarios_inver SET estado = 'inactivo' WHERE id_usuarios = " + horariosInver.getIdUsuarios().getId();
        em.createNativeQuery(sql).executeUpdate();
    }

    @Override
    public int getCountByUser(HorariosInver horariosInver) {

        try {
            String sql = "SELECT COUNT(id) FROM Horarios_inver WHERE id_usuarios = " + horariosInver.getIdUsuarios().getId();
            Integer total = Integer.valueOf(String.valueOf(em.createNativeQuery(sql).getSingleResult()));

            return total;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error COUNT(ID HORARIOS_INVER", e.getMessage()));
            return 0;

        }

    }

}
