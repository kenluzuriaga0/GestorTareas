/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
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
    public Usuarios iniciarSesion(Usuarios user){
        Usuarios usuario = null;
        
        try {
            System.out.println(user.getUsername()+" "+user.getPassword());
            Query query = em.createQuery("SELECT u FROM Usuarios u WHERE u.username= ?1 AND u.password= ?2");
            query.setParameter(1, user.getUsername());
            query.setParameter(2, user.getPassword());
            
            List<Usuarios> lista = query.getResultList();
            
            if(!lista.isEmpty()){
                usuario = lista.get(0);
            }
            
        } catch (Exception e) {
            System.out.println("Error Facade usuarios "+e.getMessage());
            throw e;
        }
        return usuario;
        
        
    }
    
    
    
}
