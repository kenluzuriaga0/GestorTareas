package controlador;

import entities.Cursos;
import entities.Libros;
import entities.Usuarios;
import entities.Varios;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sessions.Local.CursosFacadeLocal;
import sessions.Local.LibrosFacadeLocal;
import sessions.Local.UsuariosFacadeLocal;
import sessions.Local.VariosFacadeLocal;

/**
 *
 * @author kenlu
 */
@Named(value = "beanInversion")
@ViewScoped
public class BeanInversion implements Serializable {

    @EJB
    private UsuariosFacadeLocal usuariosFacade;

    @EJB
    private CursosFacadeLocal cursosFacade;

    @EJB
    private LibrosFacadeLocal librosFacade;

    @EJB
    private VariosFacadeLocal variosFacade;

    private String[] actividadProductiva;

    //models
    Cursos curso;
    Libros libro;
    Varios varios;
    Usuarios usuario;

    public BeanInversion() {

       usuario = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggeado");
        curso = new Cursos();
        libro = new Libros();
        varios = new Varios();
    }

    @PostConstruct
    public void init() {

    }

    public void definirInversion() {
        updateActivProductiva(); //merge a usuario

        agregarCursoYLibroYVarios();
    }

    private void updateActivProductiva() {
        setearActividad(); //array a String de tabla usuario
        usuariosFacade.edit(usuario);

    }

    private void setearActividad() {
        String actividad = null;
        if (actividadProductiva.length == 2) {
            actividad = actividadProductiva[0] + "-" + actividadProductiva[1];
        } else if (actividadProductiva.length == 1) {
            actividad = actividadProductiva[0];
        }
        usuario.setActivProductiva(actividad);
    }

    private void agregarCursoYLibroYVarios() {
        curso.setId(BigDecimal.valueOf(1 + cursosFacade.getMaxId()));
        cursosFacade.create(curso);

        varios.setId(BigDecimal.valueOf(1 + variosFacade.getMaxId()));
        variosFacade.create(varios);
    }

    public String[] getActividadProductiva() {
        return actividadProductiva;
    }

    public void setActividadProductiva(String[] actividadProductiva) {
        this.actividadProductiva = actividadProductiva;
    }

    public Cursos getCurso() {
        return curso;
    }

    public Libros getLibro() {
        return libro;
    }

    public Varios getVarios() {
        return varios;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

}
