/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.HorariosOcup;
import sessions.Local.LibroFacadeLocal;
import entities.Libro;
import entities.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kenlu
 */
@Stateless
public class LibroFacade extends AbstractFacade<Libro> implements LibroFacadeLocal {

    @PersistenceContext(unitName = "nek_G1_GestorTareas_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LibroFacade() {
        super(Libro.class);
    }
        @Override
    public int getMaxId() {

        try {
            return (em.createQuery("SELECT MAX(o.id) FROM Libro o", Integer.class).getSingleResult()).intValue();
        } catch (Exception nullo) {

            return 0;
        }

    }
     @Override
    public List<Libro> getTodoActivo(Usuarios usuario) {
        try {
            return em.createQuery("SELECT o FROM Libro o WHERE o.idUsuario = :idUsuario ",Libro.class)
                    .setParameter("idUsuario", usuario).getResultList();

        } catch (Exception nullo) {
            System.out.println(nullo.getMessage() + " ERROR");
            return null;
        }
    }
}
