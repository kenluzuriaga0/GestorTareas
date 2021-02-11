/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Trabajos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kenlu
 */
@Local
public interface TrabajosFacadeLocal {

    void create(Trabajos trabajos);

    void edit(Trabajos trabajos);

    void remove(Trabajos trabajos);

    Trabajos find(Object id);

    List<Trabajos> findAll();

    List<Trabajos> findRange(int[] range);

    int count();
    
}
