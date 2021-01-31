/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.HorarioInvertido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kenlu
 */
@Local
public interface HorarioInvertidoFacadeLocal {

    void create(HorarioInvertido horarioInvertido);

    void edit(HorarioInvertido horarioInvertido);

    void remove(HorarioInvertido horarioInvertido);

    HorarioInvertido find(Object id);

    List<HorarioInvertido> findAll();

    List<HorarioInvertido> findRange(int[] range);

    int count();
    
}
