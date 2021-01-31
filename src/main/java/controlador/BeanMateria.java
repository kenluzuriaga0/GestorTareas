package controlador;

import entities.Materia;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sessions.MateriaFacade;
import sessions.MateriaFacadeLocal;

/**
 *
 * @author kenlu
 */
@Named(value = "beanMateria")
@ViewScoped
public class BeanMateria implements Serializable{
    @EJB
    private MateriaFacadeLocal materiaFacade;
    private Materia materia;

    
    public void guardar(){
        materiaFacade.create(materia);
    }
    
    public MateriaFacadeLocal getMateriaFacade() {
        return materiaFacade;
    }

    public void setMateriaFacade(MateriaFacadeLocal materiaFacade) {
        this.materiaFacade = materiaFacade;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    
    
    
    public BeanMateria() {
        materia = new Materia();
        materiaFacade = new MateriaFacade();
        
    }
    
}
