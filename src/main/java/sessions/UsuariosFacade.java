/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.HorariosOcup;
import sessions.Local.AbstractFacade;
import sessions.Local.UsuariosFacadeLocal;
import entities.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kenlu
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "nek_G1_GestorTareas_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }

    @Override
    public Usuarios iniciarSesion(Usuarios user) {
        Usuarios usuario = null;

        try {
            System.out.println(user.getUsername() + " " + user.getPassword());
            Query query = em.createQuery("SELECT u FROM Usuarios u WHERE u.username= ?1 AND u.password= ?2");
            query.setParameter(1, user.getUsername());
            query.setParameter(2, user.getPassword());

            List<Usuarios> lista = query.getResultList();

            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }

        } catch (Exception e) {
            System.out.println("Error Facade usuarios " + e.getMessage());
            throw e;
        }
        return usuario;

    }

    @Override
    public Integer getMaxId() {
        try {
            return (em.createQuery("SELECT MAX(u.id) FROM Usuarios u", Integer.class).getSingleResult()).intValue();
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + " Error en getMaxId  de Usuarios");
            return 0;
        }
    }

    @Override
    public int getSueno(Usuarios usuario) {

        try {
            String sql = "SELECT horas_sueno FROM usuarios WHERE id = " + usuario.getId();
            Integer total = Integer.valueOf(String.valueOf(em.createNativeQuery(sql).getSingleResult()));

            return total;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error horas_sueno Usuarios", e.getMessage()));
            return 0;

        }

    }
    @Override
    public Float getTransporte(Usuarios usuario) {

        try {
            String sql = "SELECT tiempo_trans FROM usuarios WHERE id = " + usuario.getId();
            Float total = Float.valueOf(String.valueOf(em.createNativeQuery(sql).getSingleResult()))/60;

            return total;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error horas_sueno Usuarios", e.getMessage()));
            return 0f;

        }

    }
}
