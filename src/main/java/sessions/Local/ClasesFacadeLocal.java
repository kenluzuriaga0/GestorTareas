/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions.Local;

import entities.Clases;
import entities.HorariosOcup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kenlu
 */
@Local
public interface ClasesFacadeLocal {

    void create(Clases clases);

    void edit(Clases clases);

    void remove(Clases clases);

    Clases find(Object id);

    List<Clases> findAll();

    List<Clases> findRange(int[] range);

    int count();
    public int getMaxId();
    public List<String> getHorasLunes(HorariosOcup horaOcup) throws Exception;
    public List<String> getHorasMartes(HorariosOcup horaOcup) throws Exception;
    public List<String> getHorasMiercoles(HorariosOcup horaOcup) throws Exception;
    public List<String> getHorasJueves(HorariosOcup horaOcup) throws Exception;
    public List<String> getHorasViernes(HorariosOcup horaOcup) throws Exception;
    public List<String> getHorasSabado(HorariosOcup horaOcup) throws Exception;
}
