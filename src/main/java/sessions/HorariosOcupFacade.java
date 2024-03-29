/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import sessions.Local.HorariosOcupFacadeLocal;
import sessions.Local.AbstractFacade;
import entities.HorariosOcup;
import entities.Usuarios;
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
public class HorariosOcupFacade extends AbstractFacade<HorariosOcup> implements HorariosOcupFacadeLocal {

    @PersistenceContext(unitName = "nek_G1_GestorTareas_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorariosOcupFacade() {
        super(HorariosOcup.class);
    }

    @Override
    public int getMaxId() {

        try {
            return (em.createQuery("SELECT MAX(o.id) FROM HorariosOcup o", Integer.class).getSingleResult()).intValue();
        } catch (Exception nullo) {

            return 0;
        }

    }

    @Override
    public void disableStatusbyUser(HorariosOcup horariosOcup) {

        String sql = "UPDATE horarios_ocup SET estado = 'inactivo' WHERE id_usuario = " + horariosOcup.getIdUsuario().getId();
        em.createNativeQuery(sql).executeUpdate();
    }

    @Override
    public int getCountByUser(HorariosOcup horariosOcup) {

        try {
            String sql = "SELECT COUNT(id) FROM horarios_ocup WHERE id_usuario = " + horariosOcup.getIdUsuario().getId();
            Integer total = Integer.valueOf(String.valueOf(em.createNativeQuery(sql).getSingleResult()));

            return total;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error COUNT(ID HORARIOS_OCUP)", e.getMessage()));
            return 0;

        }

    }

    @Override
    public Float getHorasOcupadasActivo(HorariosOcup horaOcup) {
        try {
            return ((Float) em.createQuery("SELECT o.horasOcupadas FROM HorariosOcup o WHERE o.estado = :estado AND o.idUsuario = :idUsuario ")
                    .setParameter("idUsuario", horaOcup.getIdUsuario()).setParameter("estado", "activo").getSingleResult()).floatValue();

        } catch (Exception nullo) {
            System.out.println(nullo.getMessage() + " ERROR");
            return 0f;
        }
    }
    @Override
    public HorariosOcup getTodoActivo(Usuarios usuario) {
        try {
            return em.createQuery("SELECT o FROM HorariosOcup o WHERE o.estado = :estado AND o.idUsuario = :idUsuario ",HorariosOcup.class)
                    .setParameter("idUsuario", usuario).setParameter("estado", "activo").setMaxResults(1).getSingleResult();

        } catch (Exception nullo) {
            System.out.println(nullo.getMessage() + " ERROR");
            return null;
        }
    }
    

}
