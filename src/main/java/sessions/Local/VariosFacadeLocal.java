/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions.Local;

import entities.Varios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kenlu
 */
@Local
public interface VariosFacadeLocal {

    void create(Varios varios);

    void edit(Varios varios);

    void remove(Varios varios);

    Varios find(Object id);

    List<Varios> findAll();

    List<Varios> findRange(int[] range);

    int count();
    
}
