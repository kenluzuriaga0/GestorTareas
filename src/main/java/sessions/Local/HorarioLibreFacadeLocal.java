/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions.Local;

import entities.HorarioLibre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kenlu
 */
@Local
public interface HorarioLibreFacadeLocal {

    void create(HorarioLibre horarioLibre);

    void edit(HorarioLibre horarioLibre);

    void remove(HorarioLibre horarioLibre);

    HorarioLibre find(Object id);

    List<HorarioLibre> findAll();

    List<HorarioLibre> findRange(int[] range);

    int count();
    public int getMaxId();
    
    
    
}
