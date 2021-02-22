/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions.Local;

import entities.HorariosInver;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kenlu
 */
@Local
public interface HorariosInverFacadeLocal {

    void create(HorariosInver horariosInver);

    void edit(HorariosInver horariosInver);

    void remove(HorariosInver horariosInver);

    HorariosInver find(Object id);

    List<HorariosInver> findAll();

    List<HorariosInver> findRange(int[] range);

    int count();
    public int getMaxId();
}
