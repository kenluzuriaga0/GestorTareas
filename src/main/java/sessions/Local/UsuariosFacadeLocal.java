/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions.Local;

import entities.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kenlu
 */
@Local
public interface UsuariosFacadeLocal {

    void create(Usuarios usuarios);

    void edit(Usuarios usuarios);

    void remove(Usuarios usuarios);

    Usuarios find(Object id);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();
    
    Integer getMaxId();
    
    Usuarios iniciarSesion(Usuarios user);
    public int getSueno(Usuarios usuario);
    public Float getTransporte(Usuarios usuario);
    
    
}
