/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.HorariosOcup;
import javax.ejb.Stateless;
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
    
}
