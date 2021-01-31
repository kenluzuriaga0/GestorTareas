/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.TipoHorario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kenlu
 */
@Local
public interface TipoHorarioFacadeLocal {

    void create(TipoHorario tipoHorario);

    void edit(TipoHorario tipoHorario);

    void remove(TipoHorario tipoHorario);

    TipoHorario find(Object id);

    List<TipoHorario> findAll();

    List<TipoHorario> findRange(int[] range);

    int count();
    
}
