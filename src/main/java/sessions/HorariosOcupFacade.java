/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import sessions.Local.HorariosOcupFacadeLocal;
import sessions.Local.AbstractFacade;
import entities.HorariosOcup;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
            return (em.createQuery("SELECT MAX(o.id) FROM HorariosOcup o", BigDecimal.class).getSingleResult()).intValue();
        } catch (NullPointerException nullo) {
            return 0;
        }

    }
    @Override
    public void disableStatusbyUser(HorariosOcup horariosOcup){
        
        
        String sql = "UPDATE horarios_ocup SET estado = 'inactivo' WHERE id_usuario = "+BigDecimal.valueOf(horariosOcup.getIdUsuario().getId().longValue()) ;
        em.createNativeQuery(sql).executeUpdate();
    }
    @Override
    public int getCountByUser(HorariosOcup horariosOcup){
        
        try {
            Query query = em.createQuery("SELECT COUNT(o.id) FROM HorariosOcup o WHERE o.idUsuario = :id_usuario");
            query.setParameter("id_usuario", horariosOcup.getIdUsuario().getId());
            
            Integer total  = (Integer) query.getSingleResult();
            return total;
        } catch (Exception e) {
            return 0;

        }

    }

 
}
