/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions.Local;

import entities.HorariosOcup;
import entities.Usuarios;
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
    
     public void disableStatusbyUser(HorariosOcup horariosOcup);
     
     public int getCountByUser(HorariosOcup horariosOcup);
     
      public Float getHorasOcupadasActivo(HorariosOcup horaOcup);
      public HorariosOcup getTodoActivo(Usuarios usuario);
}
