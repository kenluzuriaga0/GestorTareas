/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import sessions.Local.CursosFacadeLocal;
import sessions.Local.AbstractFacade;
import entities.Cursos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kenlu
 */
@Stateless
public class CursosFacade extends AbstractFacade<Cursos> implements CursosFacadeLocal {

    @PersistenceContext(unitName = "nek_G1_GestorTareas_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CursosFacade() {
        super(Cursos.class);
    }

    @Override
    public Integer getMaxId() {
        try{
        return (em.createQuery("SELECT MAX(c.id) FROM Cursos c", Integer.class).getSingleResult()).intValue();
            
        }catch(Exception ex){
            System.out.println(ex.getMessage()+" Error en getMaxId de Cursos");
            return 0;
        }
    }
}
