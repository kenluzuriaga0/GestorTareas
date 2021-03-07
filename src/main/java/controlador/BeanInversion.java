package controlador;

import entities.Cursos;
import entities.HorariosOcup;
import entities.Libros;
import entities.Usuarios;
import entities.Varios;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sessions.Local.CursosFacadeLocal;
import sessions.Local.LibrosFacadeLocal;
import sessions.Local.UsuariosFacadeLocal;
import sessions.Local.VariosFacadeLocal;
import util.GoogleBooks;

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

    int num = 0;
    GoogleBooks google;

    public BeanInversion() {

        usuario = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggeado");
        curso = new Cursos();
        libro = new Libros();
        varios = new Varios();
        

    }

    @PostConstruct
    public void init() {
        num = 0;
        google = new GoogleBooks();
        actividadProductiva = new String[0];
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
        if (obtenerBoxSeleccionados("Lectura")) {

        }
        if (this.varios.getNombre() != null) {

            varios.setId(BigDecimal.valueOf(1 + variosFacade.getMaxId()));
            variosFacade.create(varios);
        }
        if (obtenerBoxSeleccionados("Cursos")) {
            curso.setId(BigDecimal.valueOf(1 + cursosFacade.getMaxId()));
            cursosFacade.create(curso);
        }

    }

   

    public void cambiarEstadoCheck(ValueChangeEvent e) {
        String[] ex = (String[]) e.getNewValue();
        this.setActividadProductiva(ex);
    }

    public boolean obtenerBoxSeleccionados(String texto) {
        boolean seleccionado = false;
        for (String box : this.actividadProductiva) {
            if (box.trim().equalsIgnoreCase(texto.trim())) {
                seleccionado = true;
            }
        }
        return seleccionado;
    }

    public GoogleBooks getGoogle() {
        return google;
    }

    public void setGoogle(GoogleBooks google) {
        this.google = google;
    }

    public int getNum() {

        return num++;
    }

    public void setNum(int num) {
        this.num = num;
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
