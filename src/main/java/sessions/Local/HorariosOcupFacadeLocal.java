/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions.Local;

import entities.HorariosOcup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kenlu
 */
@Local
public interface HorariosOcupFacadeLocal {

    void create(HorariosOcup horariosOcup);

    void edit(HorariosOcup horariosOcup);

    void remove(HorariosOcup horariosOcup);

    HorariosOcup find(Object id);

    List<HorariosOcup> findAll();

    List<HorariosOcup> findRange(int[] range);

    int count();
    
     public int getMaxId();
    
}