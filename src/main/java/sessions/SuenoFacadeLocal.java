/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Sueno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kenlu
 */
@Local
public interface SuenoFacadeLocal {

    void create(Sueno sueno);

    void edit(Sueno sueno);

    void remove(Sueno sueno);

    Sueno find(Object id);

    List<Sueno> findAll();

    List<Sueno> findRange(int[] range);

    int count();
    
}
